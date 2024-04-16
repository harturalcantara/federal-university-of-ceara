import React, { useState } from "react";
import EmojiPicker from "emoji-picker-react";
import * as C from "./styles";
import {
  MdSend,
  //MdAttachFile,
  MdInsertEmoticon,
  MdKeyboardVoice,
  //MdLink,
  MdPhotoLibrary,
} from "react-icons/md";
import { auth, db, storage } from "../../services/firebase";
import { useAuthState } from "react-firebase-hooks/auth";
import firebase from "firebase/compat/app";
import { v4 as uuidv4 } from "uuid";
import { getDownloadURL, ref, uploadBytes } from "firebase/storage";

const ChatFooter = ({
  editMessage,
  messageEdit,
  setMessageEdit,
  setEditMode,
  editMode,
  chatId,
  //statusMessage,
}) => {

  const [user] = useAuthState(auth);
  const [message, setMessage] = useState("");
  const [emojiPickerVisible, setEmojiPickerVisible] = useState(false);

  const toggleEmojiPicker = () => {
    setEmojiPickerVisible(!emojiPickerVisible);
  };

  const handleEmojiSelect = (emoji) => {
    setMessage((prevMessage) => prevMessage + emoji);
    setEmojiPickerVisible(false);
  };

  const handleSendMessage = (e) => {
    if (editMode) {
      editMessage(messageEdit);
      setEditMode(false);
      return;
    }

    e.preventDefault();

    db.collection("chats").doc(chatId).collection("messages").add({
      id: uuidv4(),
      message: message,
      user: user.email,
      photoURL: user.photoURL,
      timestamp: firebase.firestore.FieldValue.serverTimestamp(),
      statusMessage: false,
    });

    setMessage("");
  };

  /* Photo click. */

  const handlePhotoClick = () => {
    inputRef.current.click();
  };

  const handleFileChange = async (e) => {
    const file = e.target.files[0];

    if (file) {
      const storageRef = ref(storage, `media/${uuidv4()}_${file.name}`);

      // Faça o upload do arquivo para o Firebase Storage
      await uploadBytes(storageRef, file);

      // Obtenha a URL de download do arquivo
      const downloadURL = await getDownloadURL(storageRef);

      // Adicione a mensagem com a URL do vídeo ao Firestore
      db.collection("chats").doc(chatId).collection("messages").add({
        id: uuidv4(),
        message: downloadURL,
        user: user.email,
        photoURL: user.photoURL,
        timestamp: firebase.firestore.FieldValue.serverTimestamp(),
        statusMessage: false,
        isVideo: true, // Adicione um indicador para distinguir vídeos de imagens
      });
    }
  };

  const inputRef = React.createRef();

  /* AUDIO */
  const [audioBlob, setAudioBlob] = useState(null);
  const [isRecording, setIsRecording] = useState(false);

  const handleAudioRecording = () => {
    navigator.mediaDevices.getUserMedia({ audio: true }).then((stream) => {
      setIsRecording(true);
      const mediaRecorder = new MediaRecorder(stream);
      const audioChunks = [];

      mediaRecorder.ondataavailable = (e) => {
        if (e.data.size > 0) {
          audioChunks.push(e.data);
        }
      };

      mediaRecorder.onstop = () => {
        const audioBlob = new Blob(audioChunks, { type: "audio/wav" });
        setAudioBlob(audioBlob);
        setIsRecording(false);
      };

      mediaRecorder.start();

      setTimeout(() => {
        mediaRecorder.stop();
      }, 6000);
    });
  };

  const handleFileAudioChange = async () => {
    if (audioBlob) {
      const storageRef = ref(storage, `audio/${uuidv4()}.wav`);

      await uploadBytes(storageRef, audioBlob);

      const downloadURL = await getDownloadURL(storageRef);

      db.collection("chats").doc(chatId).collection("messages").add({
        id: uuidv4(),
        message: downloadURL,
        user: user.email,
        photoURL: user.photoURL,
        timestamp: firebase.firestore.FieldValue.serverTimestamp(),
        statusMessage: false,
        isAudio: true,
      });

      setAudioBlob(null);
    }
  };

  return (
    <C.Container>
      <C.Form onSubmit={handleSendMessage}>
        <div style={{ position: 'relative' }}>
          <MdPhotoLibrary onClick={handlePhotoClick} />
        </div>
        <MdInsertEmoticon style={{cursor:'pointer'}} onClick={toggleEmojiPicker} />
        {emojiPickerVisible && (
          <div style={{ position: 'absolute', bottom: 112 }}>
          <EmojiPicker
            width={400}
            height={400}
            skinTonesDisabled
            previewConfig={{
              showPreview: false,
            }}
            onEmojiClick={(e) => handleEmojiSelect(e.emoji)}
          />
          </div>
        )}
        <C.Input
          placeholder="Type a message..."
          onChange={(e) => {
            if (editMode) {
              setMessageEdit({ ...messageEdit, message: e.target.value });
            } else {
              setMessage(e.target.value);
            }
          }}
          value={editMode ? messageEdit.message : message}
        />

        {message ? (
          <MdSend onClick={handleSendMessage} />
        ) : (
          <MdKeyboardVoice
            onClick={handleAudioRecording}
            style={{ color: isRecording ? "red" : "black" }}
          />
        )}
        {audioBlob && (
          <MdSend onClick={handleFileAudioChange} />
        )}

        <input
          type="file"
          ref={inputRef}
          style={{ display: "none" }}
          accept="image/*,video/*"
          onChange={handleFileChange}
        />
      </C.Form>
    </C.Container>
  );
};

export default ChatFooter;
