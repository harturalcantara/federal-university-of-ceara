import React from "react";
import * as C from "./styles";
import MinhaImagem from '../../images/icons8-chat-room-color-glass-96.png';

const Default = () => {
  return (
    <C.Container>
      
      <img src={MinhaImagem} alt="Postcode" />
      <C.Title>Postcode</C.Title>
      <C.Info>
        Now you can send and receive messages without having to keep your cell phone connected to the internet.
      </C.Info>
    </C.Container>
  );
};

export default Default;
