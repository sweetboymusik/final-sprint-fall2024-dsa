import React from "react";
import logo from "../assets/logo.png";

function Logo() {
  return (
    <div className="p-2 py-4 bg-primary-800 w-36 ">
      <img src={logo} alt="" className="object-cover w-full h-full invert" />
    </div>
  );
}

export default Logo;
