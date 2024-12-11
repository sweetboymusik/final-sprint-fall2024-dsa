import React from "react";
import { Link } from "react-router-dom";

function Home() {
  return (
    <div className="flex flex-col items-center justify-center min-h-screen">
      <h1 className="text-4xl font-bold mb-4">Binary Search Tree App</h1>
      <div className="space-y-4">
        <Link to="/enter-numbers" className="text-blue-500 hover:underline">
          Enter Numbers
        </Link>
        <Link to="/previous-trees" className="text-blue-500 hover:underline">
          View Previous Trees
        </Link>
      </div>
    </div>
  );
}

export default Home;
