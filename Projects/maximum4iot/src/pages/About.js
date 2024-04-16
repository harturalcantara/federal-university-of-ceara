import React from "react";
import { Image, Container } from "react-bootstrap";
import processImage from "../images/processIot.jpg";

function About() {
  return (
    <Container>
      <h1 className="mt-5 text-center"> Maximum4IoT </h1>
      <hr></hr>
      <p className="text-justify">
        The purpose of this process is to guide software engineers in the
        evaluation activities of an Internet of Things application. This process
        is suitable for IoT applications because it includes a repository of
        NFRs and software quality measures that meet the specificities of IoT
        applications. It also suggests specific techniques and tools for
        qualitatively evaluating the application. The intention is that the
        process can be used by people with or without previous experience in
        evaluation and that it can be used during the application development
        cycle or after its implementation. The following diagram illustrates the
        flow of activities suggested by Maximum4IoT:
      </p>
      <center>
        {" "}
        <Image
          className="mt-2 mb-4"
          src={processImage}
          width="800px"
          height="500px"
        />{" "}
      </center>
      <p>
        <p>
          <p>
            <b>Step 1:</b> The first step is to select the non-functional
            requirements that the evaluators will observe during the evaluation.
            The assessors will check the Maximum Repository, where they can find
            a list of non-functional requirements for IoT applications. For this
            phase, it is essential to involve the stakeholders to ensure that
            the evaluation covers all the critical aspects of the system.{" "}
          </p>
          <p>
            {" "}
            Suppose the evaluator intends to assess the application both
            qualitatively and quantitatively. In that case, it is advisable to
            conduct the qualitative evaluation before starting the software
            measurement process, thus moving on to Step 2 - Preparing the
            qualitative evaluation. In this way, the evaluator can identify and
            resolve system interaction problems before planning the software
            measurement. If the evaluator decides not to perform the qualitative
            evaluation, he/she can skip to Step 6 - Preparing the Software
            Measurement.
          </p>
          <p>
            In this way, the evaluator can identify and resolve system
            interaction problems before planning the software measurement. If
            the evaluator decides not to perform the HCI evaluation, they can
            skip to Step 6 - Preparing the Software Measurement.
          </p>
        </p>
        <p>
          <b>Step 2:</b> Before starting the HCI evaluation, it is necessary to
          plan it, clarify its objectives, and establish which questions will be
          answered. One way to guide the planning of an evaluation is through
          the DECIDE method (PREECE et al.,2013), which invites the evaluator to
          answer seven items that will help structure the evaluation. This
          framework can be accessed via the Maximum Repository, which also
          provides a list of evaluation artifacts that can be used to conduct
          HCI evaluations of IoT applications.
        </p>
        <p>
          <b>Step 3:</b> The evaluator must conduct the HCI evaluation using the
          evaluation plan drawn up during Step 2. It is worth emphasizing the
          importance of recording the data collected so that all the data
          gathered is registered and the evaluation retains its validity.
        </p>
        <p>
          <b>Step 4:</b> The evaluator analyzes the data collected through the
          HCI evaluation and draws a report summarizing the results.
        </p>
        <p>
          <b>Step 5:</b> If the project context allows, the problems identified
          in the HCI evaluation can be corrected before moving on to the
          software quality evaluation. As with Step 1, it is up to the evaluator
          whether to conduct a new HCI evaluation to check whether the errors
          identified in the evaluation persist after the improvements made to
          the application.
        </p>
        <p>
          <p>
            {" "}
            <b>Step 6:</b> The evaluator will define the measurement plan to
            start the software quality evaluation. The measurement plan defines
            the software measures that will be collected, according to the NFRs
            chosen in step 1, as well as determining the activities to be
            carried out to collect the measures, who will carry them out, the
            assessment environment, the instruments needed and how the data will
            be interpreted.
          </p>
          <p>
            For planning, the evaluator can use the Maximum4IoT repository,
            which presents a set of quality measures applicable to the context
            of Internet of Things systems. Suppose the measures chosen by the
            evaluator need to be better defined (without measurement function,
            collection method, or interpretation). In that case, we recommend
            using the GQM approach (BASILI et al., 1994), which identifies the
            overall objectives for the evaluation and helps define metrics based
            on the objective. A more detailed explanation of the GQM approach is
            available in the repository.
          </p>
          <p>
            It is important to note that once the evaluator has decided to
            develop new measures, they must follow a structure that allows them
            to be carried out correctly. The measure must have a name, a
            description, a measurement function, an interpretation, and a
            collection method (CARVALHO et al., 2018).
          </p>
        </p>
        <p>
          <b>Step 7:</b> The software quality evaluation starts following the
          step-by-step established during the measurement plan, with software
          measures corresponding to the non-functional requirements defined in
          Step 1.
        </p>
        <p>
          <b>Step 8:</b> The software quality evaluation results are analyzed
          and reported to the stakeholders.
        </p>
        <p>
          <b>Step 9:</b> If the project context allows, the development team can
          fix the problems reported. Once the problems have been fixed, a new
          software quality evaluation is carried out to see whether the changes
          have positively or negatively impacted the measures. If the evaluator
          chooses not to continue fixing the problems reported or if the
          developers have fixed all the problems identified, the NFR evaluation
          flow is closed for this IoT application. If followed in its entirety,
          this process returns two results to the evaluators: a report for the
          HCI evaluation of the system and a report for the software quality
          evaluation.
        </p>
        <p>
          <b>References:</b>
        </p>
        <p>
          PREECE, J.; SHARP, H.; ROGERS, Y. Interaction Design: Beyond
          Human-Computer Interaction. 3. ed. Porto Alegre, Brazil: Bookman,
          2013. 44-46 p. ISBN 978-85-8260-006-1.
        </p>
        <p>
          BASILI, V. R.; CALDIERA, G.; ROMBACH, H. D. The goal question metric
          approach. In: . [S. l.: s. n.], 1994.
        </p>
        <p>
          CARVALHO, R. M.; ANDRADE, R. M. C.; Oliveira, K. M. de. Aquarium - a
          suite of software measures for hci quality evaluation of ubiquitous
          mobile applications. Journal of Systems and Software, v. 136, p. 101 –
          136, 2018. ISSN 0164-1212.
        </p>
      </p>
    </Container>
  );
}

export default About;
