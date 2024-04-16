import React, { useEffect, useRef, useState } from "react";
import { db, auth } from "../../services/firebase";
import { useCollection } from "react-firebase-hooks/firestore";
import Message from "../Message";
import { useAuthState } from "react-firebase-hooks/auth";
import * as C from "./styles";

const ChatBody = ({ setMessageEdit, setEditMode, editMessage, chatId, someState, setSomeState }) => {

  const [user, loading] = useAuthState(auth);
  const [filteredMessages, setFilteredMessages] = useState();

  if (loading) console.log('Loading!')

  const [messagesRes] = useCollection(
    db
      .collection("chats")
      .doc(chatId)
      .collection("messages")
      .orderBy("timestamp", "asc")
  );

  const refBody = useRef("");

  useEffect(() => {
    if (refBody.current.scrollHeight > refBody.current.offsetHeight) {
      refBody.current.scrollTop =
        refBody.current.scrollHeight - refBody.current.offsetHeight;
    }

    if (messagesRes?.docs) {
      setFilteredMessages(
        messagesRes.docs?.filter((m) => {
          return m.data().message.toLowerCase().includes(someState);
        })
      );
    }
  }, [someState, messagesRes]);

  const getMessage = (m) => {
    return (
      <Message
        key={m.id}
        user={m.data().user}
        editMessage={editMessage}
        setEditMode={setEditMode}
        setMessageEdit={setMessageEdit}
        message={{
          id: m.data().id ?? "NOT DEFINED",
          message: m.data().message,
          timestamp: m.data().timestamp?.toDate().getTime(),
          statusMessage: m.data().statusMessage,
        }}
        chatId={chatId}
      />
    );
  };


  const updateStatusMessage = async (messageId) => {
    const messageDocRef = db.collection("chats").doc(chatId).collection("messages").doc(messageId);
  
    try {
      const messageDocSnapshot = await messageDocRef.get();
  
      const messageData = messageDocSnapshot.data();

      if (messageData.user !== user.email) {
        await messageDocRef.update({
          statusMessage: true,
        });
        console.log("Status da mensagem atualizado com sucesso!");
      } else {
        console.log("System: e-mail é igual, irei atualizar o status da prox msg!");
      }
    } catch (error) {
      console.error("Erro ao obter/atualizar o status da mensagem:", error);
    }
  };

  const updateStatusForAllMessages = () => {
    if (messagesRes?.docs && user) {
      messagesRes.docs.forEach((message) => {
          updateStatusMessage(message.id);
      });
    } 
  };

  useEffect(() => {
    updateStatusForAllMessages();
  }, [messagesRes, user]);

  return (
    <C.Container ref={refBody}>
      {filteredMessages
        ? filteredMessages?.map((message) => getMessage(message))
        : messagesRes?.docs.map((message) => getMessage(message))}
    </C.Container>
  );
};

export default ChatBody;
