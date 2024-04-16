import styled from "styled-components";

export const StyledModal = styled.div`
  display: flexbox;
  position: fixed;
  background-color: #fff;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
  max-width: 400px;
  width: 400px;
  min-height: 300px;
  width: 100%;

  .ant-modal-content {
    display: flex;
    align-content: center;
    justify-content: center;
    text-align: center;
  }

  .email-list {
    display: flex;
  }

  /* Style for the close button */
  .close-btn {
    cursor: pointer;
    top: 10px;
    right: 10px;
    font-size: 18px;
    color: #333;
  }

  input {
    width: 400px;
    padding: 10px;
    margin: 5px;
    border: 2px solid #000000;
    border-radius: 4px;
    font-size: 16px;
  }

  input::placeholder {
    color: #999;
  }
`;
