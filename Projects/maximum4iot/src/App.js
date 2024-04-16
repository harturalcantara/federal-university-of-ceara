import { Outlet } from "react-router-dom";
import Header from "./components/Header";
import Footer from "./components/Footer";

function App() {
  return (
    <div
      style={{
        display: "grid",
        gridAutoFlow: "row",
        gridTemplateRows: "60px auto 60px",
        height: "100vh",
      }}
    >
      <Header />
      <div>
        <Outlet />
      </div>
      <Footer />
    </div>
  );
}

export default App;
