import React from "react";

function PreviousTreeItem({ tree, index, onClick }) {
  return (
    <div
      key={index}
      className="border rounded p-4 cursor-pointer flex justify-between hover:bg-primary-100"
      onClick={() => onClick(JSON.parse(tree.treeStructure))}
    >
      <div>
        <p>
          <strong>Input Numbers:</strong>{" "}
          {JSON.stringify(tree.inputNumbers, null, " ")}
        </p>

        <p>
          <strong>Tree Structure:</strong> (Click to view)
        </p>
      </div>
    </div>
  );
}

export default PreviousTreeItem;
