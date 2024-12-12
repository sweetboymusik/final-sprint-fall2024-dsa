import React from "react";
import { Link } from "react-router-dom";

function HeroButton({ label, icon, message, to }) {
  return (
    <Link
      to={to}
      className="bg-primary-800 text-white rounded flex flex-col gap-4 justify-center items-center h-48 w-full hover:bg-primary-600"
    >
      <div className="flex items-center justify-center gap-4 text-3xl">
        {icon}
        <span>{label}</span>
      </div>
      <p>{message}</p>
    </Link>
  );
}

export default HeroButton;
