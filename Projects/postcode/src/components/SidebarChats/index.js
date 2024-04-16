import React from "react";
import { useAuthState } from "react-firebase-hooks/auth";
import { auth, db } from "../../services/firebase";
import * as C from "./styles";
import { useCollection } from "react-firebase-hooks/firestore";
import SidebarChatsItem from "../SidebarChatsItem";

const SidebarChats = ({ setUserChat, userChat }) => {
  const [user] = useAuthState(auth);

  const refChat = db
    .collection("chats")
    .where("users", "array-contains", user.email);

  const [chatsSnapshot] = useCollection(refChat);

  return (
    <C.Container>
      <div className="wrap-input200 validate-input" style={{borderRadius: "0px", border: "1px solid #ccc"}}>
        <input
          className="input100"
          style={{
            width: "250px",
            height: "36px",
            paddingLeft: "35px",
            backgroundImage: 'url("https://i.imgur.com/1uLaGFd.png")',
            backgroundPosition: "10px 50%",
            backgroundRepeat: "no-repeat",
            backgroundSize: "16px 16px",
            fontSize: "16px",
          }}
          placeholder="Search user..."
        />
        <span className="focus-input200"></span>
      </div>
      {chatsSnapshot?.docs.map((item, index) => (
        <C.Content key={index}>
          <SidebarChatsItem
            id={item.id}
            users={item.data().users}
            user={user}
            setUserChat={setUserChat}
            active={userChat?.chatId === item.id ? "active" : ""}
          />
          <C.Divider />
        </C.Content>
      ))}
    </C.Container>
  );
};

export default SidebarChats;
