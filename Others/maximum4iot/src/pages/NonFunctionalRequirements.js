import React, { useEffect } from "react";
import { useNavigate } from "react-router-dom";
import Table from "../components/Table";
import Service from "../service/Service";
import "../css/global.css";

function NonFunctionalRequirements(props) {
  const navigate = useNavigate();
  const [selectedRows, setSelectedRows] = React.useState(null);

  let data = Service(0);

  const columns = React.useMemo(
    () => [
      {
        Header: "NFR",
        accessor: "NFR",
      },
      {
        Header: "Description",
        accessor: "Description",
      },
      {
        Header: "Reference",
        accessor: "Reference",
      },
    ],
    []
  );

  const handleNextStep = () => {
    const step1Data = JSON.parse(localStorage.getItem("step1"));
    if (!step1Data || step1Data.length === 0) {
      alert("No Non-functional requirements selected! Try again!");
    } else {
      navigate("/artifacts", {
        state: { data: selectedRows },
      });
    }
  };

  useEffect(() => {
    localStorage.setItem("step1", JSON.stringify(selectedRows));
  }, [selectedRows]);

  return (
    <div>
      <div className="container fluid mt-4">
        <h4 style={{ color: "#186aa4" }}>CHOOSE THE NFRS</h4>
        <h5>
          {" "}
          At the first stage of the process, the non-functional requirements to
          be assessed are selected. Engaging stakeholders is essential for the
          this fase to ensure that the evaluation is carried out efficiently and
          covers all critical aspects of the sustem to be assessed.{" "}
        </h5>
      </div>

      <Table
        columns={columns}
        data={data}
        onSelectedRowsClicked={(selectedRow) => setSelectedRows(selectedRow)}
      />

      <div className="d-flex justify-content-center align-items-center">
        <button
          className="btn btn-primary btn-lg active mb-4"
          size="lg"
          style={{ backgroundColor: "#186aa4", width: "192px" }}
          onClick={handleNextStep}
        >
          NEXT STEP
        </button>
      </div>
    </div>
  );
}

export default NonFunctionalRequirements;
