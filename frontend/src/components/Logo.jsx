import React from "react";
import logo from "../assets/logo.png";

function Logo() {
  return (
    <div className="p-2 pr-8 py-4 bg-primary-800 w-36 h-28">
      <img src={logo} alt="" className="object-cover w-full h-full invert" />
    </div>
  );
}

export default Logo;
