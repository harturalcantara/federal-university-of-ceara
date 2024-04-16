import React, { useEffect, useState } from "react";
import Chat from "./components/Chat";
import Sidebar from "./components/Sidebar";
import { useAuthState } from "react-firebase-hooks/auth";
import { auth, db } from "./services/firebase";
import Login from "./components/Login";
import Loading from "./components/Loading";
import * as C from "./styles/app";


const App = () => {
  const [user, loading] = useAuthState(auth);
  const [userChat, setUserChat] = useState(null);
  const [userBD, setUserBD] = useState(null);

  useEffect(() => {
    const fetchUserData = async () => {
      if (user) {
        const userData = await db.collection("users").where('email', "==", user.email).get();
        setUserBD(userData);
      }
    };

    fetchUserData();
  }, [user]);
  
  useEffect(() => {
      if (userBD && userBD.docs.length > 0) {
        console.log('Existe um usuário, não irei fazer nada!');
      } else {
          if (user) {
            db.collection("users").doc(user.uid).set({
              name: user.displayName,
              email: user.email,
              photoURL: user.photoURL,
              description: "Define a description...",
            });
        }
      }
  }, [user, userBD]);
  
  if (loading) return <Loading />;

  if (!user) return <Login />;

  return (
    <C.StyledContainer>
      <C.Container>
        <Sidebar setUserChat={setUserChat} userChat={userChat} />
        <Chat userChat={userChat} />
      </C.Container>
    </C.StyledContainer>
  );
};

export default App;
