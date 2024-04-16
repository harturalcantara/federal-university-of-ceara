import styled from "styled-components";

export const Container = styled.div``;

export const Line = styled.div`
  margin: 10px;
  display: flex;

  &.me {
    > div {
      background-color: #dcf8c6;
    }
    justify-content: right;
  }
`;

export const Content = styled.div`
  background-color: #fff;
  border-radius: 10px;
  box-shadow: 0 1px 1px #ccc;
  display: flex;
  flex-direction: column;
  padding: 3px;
  max-width: 80%;
  text-align: left;

`;

export const Message = styled.span`
  font-size: 14px;
  margin: 10px 50px 10px 10px;
`;

export const MessageActions = styled.span`
  p {
    color: gray;
  }
  p:hover {
    color: black;
    cursor: pointer;
  }
`;

export const MessageDate = styled.span`
  font-size: 11px;
  color: #999;
  text-align: left;
  height: 15px;
  margin: -5px 5px 0;

  &.me {
    text-align: right;
  }
`;

export const flexContainer = styled.span`
  display: flex;
  justify-content: space-between;
`;

export const leftContent = styled.span`
  align-self: flex-start;
`;

export const rightContent = styled.span`
  align-self: flex-end;
`;
