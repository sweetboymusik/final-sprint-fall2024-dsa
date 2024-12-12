import React from "react";
import { FaTrash } from "react-icons/fa6";

function PreviousTreeItem({ tree, index, onClick, onRemove }) {
  console.log(tree.id);
  return (
    <div
      key={index}
      className="border rounded p-4 cursor-pointer flex justify-between"
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

      <button
        type="button"
        onClick={() => onRemove(tree?.id)}
        className="text-red-500 hover:text-red-800"
      >
        <FaTrash />
      </button>
    </div>
  );
}

export default PreviousTreeItem;
