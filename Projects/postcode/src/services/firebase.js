import firebase from "firebase/compat/app";
import "firebase/compat/auth";
import "firebase/compat/firestore";
import { getStorage } from "firebase/storage";


const firebaseConfig = {
  apiKey: "AIzaSyD9wyxBmhm7ZBckm5ofAH6E-1heKa0MEEc",
  authDomain: "tutorial-crud-23ca4.firebaseapp.com",
  projectId: "tutorial-crud-23ca4",
  storageBucket: "tutorial-crud-23ca4.appspot.com",
  messagingSenderId: "73737924608",
  appId: "1:73737924608:web:a9e8a55244cc08930428e5",
  measurementId: "G-1YBMBWPX76"
};

const app = firebase.initializeApp(firebaseConfig);

const db = app.firestore();
const auth = app.auth();
const provider = new firebase.auth.GoogleAuthProvider();
const storage = getStorage(app);

export { db, auth, provider, storage };
