import React, {useState} from "react";
import { Image, Container, Dropdown } from "react-bootstrap";
import gqmImage from "../images/gqm.jpg";

function ComplementaryArtifacts() {
  const [selectedItem, setSelectedItem] = useState("DECIDE Framework");

  const handleSelect = (item) => {
    setSelectedItem(item);
  };

  return (
    <Container>
      <h4 className="mt-5">Choose one of the complementary artifacts:</h4>
      <Dropdown onSelect={handleSelect}>
        <Dropdown.Toggle style={{ backgroundColor: "#186aa4", width: "192px" }} id="dropdown-basic">
          {selectedItem}
        </Dropdown.Toggle>
        <Dropdown.Menu>
          <Dropdown.Item eventKey="DECIDE Framework">
            DECIDE Framework
          </Dropdown.Item>
          <Dropdown.Item eventKey="GQM Approach">GQM Approach</Dropdown.Item>
        </Dropdown.Menu>
      </Dropdown>
      {selectedItem === "DECIDE Framework" && (
        <>
          <h1 className="mt-5 text-center"> DECIDE Framework </h1>
          <hr></hr>
          <p className="text-justify">
            One way to guide the planning of a qualitative evaluation is through
            the DECIDE method, which invites the evaluator to answer seven items
            that will help structure the evaluation.
          </p>
          <p>
            <p>
              <b>D - </b> Determine the general objectives of the evaluation;
              Ex: Evaluate user satisfaction with a ticket purchasing system.
            </p>
            <p>
              <b>E - </b> Explore the specific questions to be answered; Ex: Is
              the system easy to use? Is the user interface pleasant? Does the
              user feel comfortable using the system? Would the user recommend
              this system to other people?
            </p>
            <p>
              <b>C - </b> Choose the tools and techniques to be used in the
              evaluation; Ex: Usability test and SUS questionnaire.
            </p>
            <p>
              <b>I - </b> Identify practical issues that need to be considered,
              such as the environment, the professionals who will conduct the
              evaluation, whether the evaluation will involve users and, if so,
              what the user profile is, among other details; Ex: An observation
              laboratory will be used to carry out the usability tests, the
              evaluation will take place on date X, 2 professionals will be
              needed, an evaluator and an observer. Participants must be between
              18 and 45 years old, live in city X and go to the movies at least
              once a month. The evaluations will be recorded. At the end of the
              usability test, the SUS questionnaire will be completed.
            </p>
            <p>
              <b>D - </b>Decide how to deal with ethical issues, and finally;
              Ex: Definition of the informed consent form, guarantee of
              anonymity of the participants, no participants under the age of 18
              will be allowed"
            </p>
            <p>
              <b>E - </b> Evaluate, interpret and report the results Ex: The
              results of the evaluation will be disseminated through an
              evaluation report and a presentation to the stakeholders, where a
              table will be presented with the tasks that the user performed,
              whether it was possible to complete them and in how much time, a
              list summarizing the user's main complaints in relation to the
              interaction flow and user interface and, finally, the answers to
              the SUS questionnaire will be summarized through graphs.
            </p>
            <p>
              If you need more details on the framework and its application,
              please see the study's reference: PREECE, J.; SHARP, H.; ROGERS,
              Y. Interaction Design: Beyond Human-Computer Interaction. 3. ed.
              Porto Alegre, Brazil: Bookman, 2013. 44-46 p. ISBN
              978-85-8260-006-1.
            </p>
          </p>
        </>
      )}
      {selectedItem === "GQM Approach" && (
        <>
          <h1 className="mt-5 text-center"> GQM Approach </h1>
          <hr></hr>
          <p>
            The Goal Question Metric approach is designed to help the
            measurement activity actually correspond to the previously defined
            goals. Once the information needs are well-defined, it is possible
            to establish questions that help obtain this information and finally
            define which metrics to collect to answer these questions.{" "}
          </p>
          <center>
            {" "}
            <Image src={gqmImage} />{" "}
          </center>
          <p>
            As an example, imagine that a company wants to know how its
            employees' self-promotion is going. The person responsible for
            dealing with the request asks the following questions: - How often
            does the company suggest new training to the employee? - Does the
            company seek to reward employees who are improving their skills? In
            order to answer the first question, the evaluator established the
            following metric : X= Number of training proposals per semester. For
            the second question, the metric could be: Y=Quantity of employees
            rewarded by certifications, training or new titles/Quantity of total
            employees.
          </p>
          <p>
            If you need more details on the framework and its application,
            please see the study's reference: BASILI, V. R.; CALDIERA, G.;
            ROMBACH, H. D. The goal question metric approach. In: . [S. l.: s.
            n.], 1994.
          </p>
        </>
      )}
    </Container>
  );
}

export default ComplementaryArtifacts;
