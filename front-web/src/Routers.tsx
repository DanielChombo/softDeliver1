import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from "./Home";
import NavBar from "./NavBar";
import Orders from "./Orders";

function Rotas() {
  return (
    <BrowserRouter>
        <NavBar/>
      <Routes>
        <Route path="/orders" element={<Orders />} />
        <Route path="/" element={<Home />} />
      </Routes>
    </BrowserRouter>
  );
}

export default Rotas;
