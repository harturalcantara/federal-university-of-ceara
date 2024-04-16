import { React, useState } from "react";
import * as C from "./styles";
import { MdPerson } from "react-icons/md";
import iconEllipsis from "../../images/icon_ellipsis_vertical.png";
import { db } from "../../services/firebase";
import { Modal } from "antd";

const ChatHeader = ({
  photoURL,
  name,
  email,
  uid,
  setSomeState,
  chatIdToDelete,
}) => {
  const [searchInput, setSearchInput] = useState("");
  const [isModalOpen, setIsModalOpen] = useState(false);

  const showModal = () => {
    setIsModalOpen(true);
  };

  const handleOk = () => {
    setIsModalOpen(false);
  };

  const handleCancel = () => {
    setIsModalOpen(false);
  };

  const deleteUserChat = async () => {
    try {
      const userRef = await db
        .collection("chats")
        .doc(chatIdToDelete)
        .collection("messages")
        .get();

      const deletePromises = userRef.docs.map(async (doc) => {
        await db
          .collection("chats")
          .doc(chatIdToDelete)
          .collection("messages")
          .doc(doc.id)
          .delete();
        console.log(`Document with ID ${doc.id} deleted successfully.`);
      });

      await Promise.all(deletePromises);
      await db.collection("chats").doc(chatIdToDelete).delete();
      window.location.reload(true);
      alert("Chat deleted!");
    } catch (error) {
      alert("Error deleting user:", error.message);
    }
  };

  const handleSearchSubmit = (event) => {
    event.preventDefault();
    setSomeState(searchInput);
    setSearchInput("");
  };

  const DropdownMenu = ({ isOpen, onClose }) => {
    // O conteúdo do dropdown vai aqui
    return (
      <C.MessageActions
        style={{
          display: isOpen ? "block" : "none",
          position: "absolute",
          width: "132px",
          top: "32px",
          right: "0",
          backgroundColor: "#fff",
          border: "2px solid #ccc",
          padding: "16px",
          zIndex: 1,
        }}
      >
        <p onClick={deleteUserChat}> Delete chat</p>
        <hr></hr>
        <p>Sair</p>
      </C.MessageActions>
    );
  };

  const [isDropdownOpen, setDropdownOpen] = useState(false);

  const handleDropdownClick = () => {
    setDropdownOpen(!isDropdownOpen);
  };

  return (
    <C.Container>
      <C.UserInfo>
        {photoURL ? (
          <C.Avatar src={photoURL} alt="Avatar" onClick={showModal} />
        ) : (
          <MdPerson />
        )}
        <Modal
          title="Perfil"
          open={isModalOpen}
          onOk={handleOk}
          onCancel={handleCancel}
        >
          <div style={{ textAlign: "center" }}>
            <C.Avatar src={photoURL} />
            <h4>
              <b> {name} </b>
            </h4>
            <hr></hr>
            <p>
              {" "}
              <b>Email: {email} </b>{" "}
            </p>
            <p>
              {" "}
              <b>UID: {uid} </b>{" "}
            </p>
            <p>
              {" "}
              <b>Descrição:</b> ...{" "}
            </p>
          </div>
        </Modal>
        <C.NameContent>
          <C.Name>{name}</C.Name>
        </C.NameContent>
      </C.UserInfo>
      <C.Options>
        <form onSubmit={handleSearchSubmit}>
          <div className="wrap-input100 validate-input">
            <input
              className="input100"
              onChange={(e) => setSearchInput(e.target.value)}
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
              value={searchInput}
              placeholder="Search message..."
            />
            <span className="focus-input100"></span>
          </div>
        </form>
        <div style={{ position: "relative" }}>
          <img
            style={{ cursor: "pointer" }}
            className="m-t-8"
            width={"24px"}
            height={"24px"}
            src={iconEllipsis}
            alt="options"
            onClick={handleDropdownClick}
          />

          <DropdownMenu
            isOpen={isDropdownOpen}
            onClose={() => setDropdownOpen(false)}
          />
        </div>
      </C.Options>
    </C.Container>
  );
};

export default ChatHeader;
