import { createGlobalStyle } from "styled-components";

const GlobalStyle = createGlobalStyle`
  * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
  }
  body {
    width: 100vw;
    height: 100vh;
    font-family:  'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  }


  .ant-modal-content h3 {
    font-weight: 600;
    text-align: center;
  }

  .ant-modal-content .email-list{
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-items: center;
    justify-content: center;

  }
  

  .ant-modal-content .email-list input{
    margin-top: 10px;
    height: 20px;
    width: 200px;
    margin-left: auto;
    margin-right: auto;
  }

  .ant-modal-content .email-list .add-user {
    margin-top: 15px;
  }
`;

export default GlobalStyle;
