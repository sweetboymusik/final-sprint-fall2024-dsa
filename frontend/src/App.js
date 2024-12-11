import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import Input from "./pages/Input";
import History from "./pages/History";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/enter-numbers" element={<Input />} />
        <Route path="/previous-trees" element={<History />} />
      </Routes>
    </Router>
  );
}

export default App;
