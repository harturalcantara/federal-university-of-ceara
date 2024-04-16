import React from "react";
import { auth, provider } from "../../services/firebase";
import "./main.css";
import "./util.css";
import MinhaImagem from "../../images/icons8-chat-room-color-glass-96.png";

const Login = () => {
  const handleSignin = () => {
    auth.signInWithPopup(provider).catch(alert);
  };
  return (
    <>
      <div className="limiter">
        <div className="container-login100">
          <div className="wrap-login100 p-l-110 p-r-110 p-t-62 p-b-33">
            <center>
              <img width={"48px"} src={MinhaImagem} alt="Postcode" />
            </center>
            <center>
              <h3 className="m-t-8">
                <b>Postcode </b>
              </h3>
            </center>
            <form className="login100-form validate-form flex-sb flex-w">
              <div className="p-t-31 p-b-9">
                <span className="txt1">Username</span>
              </div>
              <div
                className="wrap-input100 validate-input"
                data-validate="Username is required"
              >
                <input className="input100" type="text" name="username" />
                <span className="focus-input100"></span>
              </div>

              <div className="p-t-13 p-b-9">
                <span className="txt1">Password</span>

                <a href="https://www.example.com" className="txt2 bo1 m-l-5">
                  Forgot?
                </a>
              </div>
              <div
                className="wrap-input100 validate-input"
                data-validate="Password is required"
              >
                <input className="input100" type="password" name="pass" />
                <span className="focus-input100"></span>
              </div>

              <div className="container-login100-form-btn m-t-17">
                <button className="login100-form-btn">Sign In</button>
              </div>

              <span className="login100-form-title p-b-30 m-t-30">
                <center>
                  {" "}
                  <h5> Sign In With </h5>{" "}
                </center>
              </span>

              <a href="https://www.example.com" className="btn-face m-b-8">
                <i className="fa fa-facebook-official"></i>
                Facebook
              </a>

              <a
                href="https://www.example.com"
                className="btn-google m-b-8"
                onClick={(e) => {
                  e.preventDefault();
                  handleSignin();
                }}
              >
                <i className="fa fa-google"></i>
                <div className="m-l-20"> Google </div>
              </a>

              <div className="w-full text-center p-t-32">
                <span className="txt2">Not a member?</span>

                <a href="https://www.example.com" className="txt2 bo1 m-l-5">
                  Sign up now
                </a>
              </div>
            </form>
          </div>
        </div>
      </div>

      <div id="dropDownSelect1"></div>
    </>
  );
};

export default Login;
