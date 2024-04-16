import React, { useState } from "react";
import { Modal, Form, Button } from "antd";
import { MdControlPoint } from "react-icons/md";

const CreateChatModal = ({
  isOpen,
  setIsOpen,
  emails,
  setEmails,
  onSubmit,
}) => {
  const [form] = Form.useForm();
  const [newEmail, setNewEmail] = useState("");

  const handleInputChange = (e) => {
    setNewEmail(e.target.value);
  };

  const handleAddNewContact = () => {
    if (newEmail) {
      form.resetFields();
      setEmails([...emails, newEmail]);
      setNewEmail("");
    }
  };

  const handleOk = () => {
    if (newEmail) {
      setEmails([...emails, newEmail]);
      onSubmit([...emails, newEmail]);
    } else {
      onSubmit(emails);
    }
    setNewEmail("");
    setEmails("");
    form.resetFields();
  };

  const handleCancel = () => {
    form.resetFields();
    setNewEmail("");
    setEmails([]);
    setIsOpen(false);
  };

  return (
    <Modal
      open={isOpen}
      footer={[
        <div key="buttons" style={{ textAlign: "center" }}>
          <Button key="cancel" onClick={handleCancel}>
            Cancel
          </Button>
          <Button key="ok" type="primary" onClick={handleOk}>
            Ok
          </Button>
        </div>,
      ]}
    >
      <h3> Start a new chat </h3>
      <hr></hr>
      <h5 className=" m-t-8">
        Enter your email to start a conversation, add more than one email to
        form a group.
      </h5>
      <Form form={form}>
        <div
          className="wrap-input100 validate-input m-t-27"
          style={{ display: "flex" }}
        >
          <input
            className="input100"
            onChange={handleInputChange}
            value={newEmail}
            placeholder="Write the e-mail to start chat..."
            style={{ height: "50px" }}
          />
          <span className="focus-input100"></span>
          <button
            style={{ width: "60px", height: "50px" }}
            className="login100-form-btn"
            onClick={handleAddNewContact}
          >
            <MdControlPoint size={100} />
          </button>
        </div>
        <div className="email-list m-t-16">
          <h5 className=" m-t-8 m-b-16">Starting a chat with: </h5>
          {emails && (
            <ul className="m-b-16">
              {emails.map((email) => {
                return (
                  <li key={email}>
                    {" "}
                    <h5>{email}</h5>{" "}
                  </li>
                );
              })}
            </ul>
          )}
        </div>
      </Form>
    </Modal>
  );
};

export default CreateChatModal;
