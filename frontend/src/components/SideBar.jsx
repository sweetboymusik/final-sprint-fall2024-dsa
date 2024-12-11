import React from "react";
import { useLocation } from "react-router-dom";
import SideBarItem from "./SideBarItem";
import { FaDiagramProject, FaHouse, FaPenToSquare } from "react-icons/fa6";
import Logo from "./Logo";

function SideBar() {
  const location = useLocation();

  const isActive = (path) => {
    if (path === "/") {
      return location.pathname === "/";
    }
    return location.pathname.startsWith(path);
  };

  return (
    <div className="flex flex-col gap-4 w-36 border-r h-full">
      <Logo />

      <SideBarItem
        icon={<FaHouse />}
        label={"Home"}
        to={"/"}
        active={isActive("/")}
      />
      <hr className="w-2/3 self-center" />

      <SideBarItem
        icon={<FaPenToSquare />}
        label={"Add New Tree"}
        to={"/enter-numbers"}
        active={isActive("/enter-numbers")}
      />
      <hr className="w-2/3 self-center" />

      <SideBarItem
        icon={<FaDiagramProject />}
        label={"View Trees"}
        to={"/previous-trees"}
        active={isActive("/previous-trees")}
      />
    </div>
  );
}

export default SideBar;
