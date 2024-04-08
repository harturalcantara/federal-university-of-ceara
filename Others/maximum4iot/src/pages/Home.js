import React from "react";
import { useNavigate } from "react-router-dom";

function Home() {
  const navigate = useNavigate();
  return (
    <div style={{alignContent: 'center', display: 'grid', height: '100%'}}>
      <center>
        <div className="container fluid" style={{ display: "flex", flexDirection: "column", minHeight: "100%",alignItems: "center", justifyContent: "center", margin:'auto'}}>
          <h1 className="mb-4" style={{ color: "#186aa4" }}>
            Maximum4IoT is a NFR evaluation process for IoT Systems{" "}
          </h1>
          <button
            className="btn btn-primary btn-lg active mb-2"
            size="lg"
            style={{ backgroundColor: "#286aa4", width: "292px", borderRadius: "0"}}
            onClick={() => navigate("/nonfuncionalrequirements")}
          >
            START AN EVALUATION
          </button>
          <p style={{ color: "#186aa4", textDecoration: "underline", cursor: "pointer"}} onClick={() =>
              navigate("/about")}>
            I wanna know more about the process.
          </p>
        </div>
      </center>
    </div>
  );
}

export default Home;