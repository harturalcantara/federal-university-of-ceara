import React from 'react';
import App from './App';
import NonFunctionalRequirements from './pages/NonFunctionalRequirements';
import Artifacts from './pages/Artifacts';
import SoftwareMetrics from './pages/SoftwareMetrics';
import EvaluationPlan from './pages/EvaluationPlan';
import About from './pages/About';
import Home from './pages/Home';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import OurTeam from './pages/OurTeam';
import ComplementaryArtifacts from './pages/ComplementaryArtifacts';


const createRoutes = () => (
        <React.StrictMode>
            <Router basename="/maximum4iot">
            <Routes>
                <Route path='/' element={<App />}>
                <Route index element={<Home />} />
                <Route path='/nonfuncionalrequirements' element={<NonFunctionalRequirements />} />
                <Route path='/artifacts' element={<Artifacts />} />
                <Route path='/softwaremetrics' element={<SoftwareMetrics />}/>
                <Route path='/complementaryartifacts' element={<ComplementaryArtifacts />} />
                <Route path='/ourteam' element={<OurTeam />} /> 
                <Route path='/about' element={<About />} />
                <Route path='/evaluationplan' element={<EvaluationPlan />} />
                </Route>
            </Routes>
            </Router>
        </React.StrictMode>
    );

export default createRoutes;
