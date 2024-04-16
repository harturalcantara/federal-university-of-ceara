import { React, useState, useEffect, useRef } from "react";
import * as C from "./styles";
import { useAuthState } from "react-firebase-hooks/auth";
import { auth } from "../../services/firebase";
import { db } from "../../services/firebase";
import { MdExpandMore, MdDone, MdDoneAll } from "react-icons/md";

const Message = ({
  editMessage,
  setMessageEdit,
  setEditMode,
  user,
  message,
  chatId,
  setEditionMode,
  setMessageEdition,
}) => {
  const [userLoggedIn] = useAuthState(auth);

  const deleteMessage = async () => {
    // Query to find documents based on the specified field value
    const querySnapshot = await db
      .collection("chats")
      .doc(chatId)
      .collection("messages")
      .where("id", "==", message.id)
      .get();

    // Iterate over the query results and delete each document
    const deletePromises = querySnapshot.docs.map(async (doc) => {
      await db
        .collection("chats")
        .doc(chatId)
        .collection("messages")
        .doc(doc.id)
        .delete();
      console.log(`Document with ID ${doc.id} deleted successfully.`);
    });

    // Wait for all delete operations to complete
    await Promise.all(deletePromises);
  };

  const triggerEdition = async () => {
    setEditMode(true);
    setMessageEdit(message);
  };

  const [isDropdownOpen, setDropdownOpen] = useState(false);
  const [clickPosition, setClickPosition] = useState({ x: 0, y: 0 });

  const handleButtonClick = (e) => {
    setClickPosition({ x: e.clientX, y: e.clientY });
    setDropdownOpen(!isDropdownOpen);
  };

  const DropdownMenu = ({ isOpen, onClose, position }) => {
    const dropdownRef = useRef(null);

    useEffect(() => {
      if (isOpen) {
        if (position) {
          const { x, y } = position;
          dropdownRef.current.style.position = "absolute";
          dropdownRef.current.style.left = `${x - 140}px`;
          dropdownRef.current.style.top = `${y}px`;
          dropdownRef.current.style.zIndex = 1000;
        }
      }
    }, [isOpen, position]);

    return (
      <C.MessageActions
        ref={dropdownRef}
        // onBlur={}
        style={{
          display: isOpen ? "block" : "none",
          width: "150px",
          backgroundColor: "#fff",
          border: "2px solid #ccc",
          padding: "16px",
        }}
      >
        <p onClick={triggerEdition}>Edit message</p>
        <hr />
        <p onClick={deleteMessage}>Delete message</p>
      </C.MessageActions>
    );
  };

  const MessageImgVideoAudio = ( message ) => {
    const isImage = message.includes(".png") || message.includes(".jpg") || message.includes(".jpeg");
    const isVideo = message.includes(".mp4") || message.includes(".webm");
    const isAudio = message.includes(".wav") || message.includes(".mp3");
  
    if (isImage) {
      return <img height={200} src={message} alt="Imagem" />;
    } else if (isVideo) {
      return (
        <video controls width="300">
          <source src={message} type="video/mp4" />
          Your browser does not support the video tag.
        </video>
      );
    } else if (isAudio) {
      return (
        <audio controls>
          <source src={message} type="audio/wav" />
          Your browser does not support the audio tag.
        </audio>
      );
    } else {
      return <p>{message}</p>;
    }
  };

  return (
    <C.Container>
      <C.Line className={userLoggedIn?.email === user ? "me" : ""}>
        <C.Content className={userLoggedIn?.email === user ? "me" : ""}>
          <C.MessageDate className={userLoggedIn?.email === user ? "me" : ""}>
            <b className="" style={{ fontSize: "11px", marginBottom: "8px" }} >
              {/* @{user.split("@")[0]} */}@{user}
            </b>
            {userLoggedIn?.email === user && (
              <MdExpandMore
                fontSize={18}
                style={{ cursor: "pointer" }}
                onClick={handleButtonClick}
              />
            )}
            <DropdownMenu
              isOpen={isDropdownOpen}
              onClose={() => setDropdownOpen(false)}
              position={clickPosition}
            />
          </C.MessageDate>

          <C.Message>  {MessageImgVideoAudio(message.message)} </C.Message>
          <C.MessageDate className={userLoggedIn?.email === user ? "me" : ""}>
            at {new Date(message?.timestamp).toLocaleString()}{" "}
            {userLoggedIn?.email === user && (
              <>
                {" "}
                {message?.statusMessage ? (
                  <MdDoneAll style={{ color: "blue", fontSize: "12px" }} />
                ) : (
                  <MdDone />
                )}
              </>
            )}
          </C.MessageDate>
        </C.Content>
      </C.Line>
    </C.Container>
  );
};

export default Message;
