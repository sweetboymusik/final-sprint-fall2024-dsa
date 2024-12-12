import React, { useEffect } from "react";
import Page from "../components/Page";
import HeroButton from "../components/HeroButton";
import { FaDiagramProject, FaPenToSquare } from "react-icons/fa6";

function Home() {
  const newMessage = "Get started by adding a new list of numbers!";
  const viewMessage = "View all previous trees and see their visualizations!";

  useEffect(() => {
    document.title = "Home";
  }, []);

  return (
    <Page label={"Home"}>
      <div className="flex flex-col gap-10">
        <p>
          Welcome to the <strong>binary search tree</strong> visualization site!
          Here you can input a list of numbers and view them in a binary search
          tree format. Created by Elliott Butt for his final sprint project of
          the Keyin College Software Development Program.
        </p>

        <div className="flex justify-between gap-10">
          <HeroButton
            icon={<FaPenToSquare />}
            label={"New Tree"}
            message={newMessage}
            to={"/enter-numbers"}
          />
          <HeroButton
            icon={<FaDiagramProject />}
            label={"All Tree"}
            message={viewMessage}
            to={"/previous-trees"}
          />
        </div>
      </div>
    </Page>
  );
}

export default Home;
