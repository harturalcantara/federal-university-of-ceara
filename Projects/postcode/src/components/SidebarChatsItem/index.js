import { React } from "react";
import { useCollection } from "react-firebase-hooks/firestore";
import { db } from "../../services/firebase";
import * as C from "./styles";
import { MdPerson } from "react-icons/md";

const getUser = (users, userLogged) =>
  users?.filter((user) => user !== userLogged?.email)[0];

const SidebarChatsItem = ({ id, users, user, setUserChat, active }) => {

  const [getUserItem] = useCollection(
    db.collection("users").where("email", "==", getUser(users, user))
  );

  const Avatar = getUserItem?.docs?.[0]?.data();

  // const item = getUser(users, user);

  // const getName = () => {
  //   if(users.length > 2) {
  //     return "Group chat"
  //   } else {
  //     return item.split("@")[0]
  //   }
  // }

  const getRealName = () => {
    if (users.length > 2) {
      return "Group chat";
    } else {
      return Avatar?.name;
    }
  };

  const getAvatar = () => {
    if (users.length > 2) {
      // return Avatar?.photoURL
      return "https://i.imgur.com/5hdeXEP.png";
    } else {
      return Avatar?.photoURL;
    }
  };

  const handleNewChat = () => {
    const userChat = {
      chatId: id,
      name: getRealName(),
      photoURL: getAvatar(),
    };

    setUserChat(userChat);
  };

  return (
    <C.Container onClick={handleNewChat} className={active}>
      {Avatar ? <C.Avatar src={getAvatar()} /> : <MdPerson />}
      <C.Name>{getRealName()}</C.Name>
    </C.Container>
  );
};

export default SidebarChatsItem;
