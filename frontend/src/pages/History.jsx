import React, { useState, useEffect } from "react";
import axios from "axios";
import TreeDiagram from "../components/TreeDiagram";

const HistoryPage = () => {
  const [trees, setTrees] = useState([]);
  const [error, setError] = useState(null);
  const [selectedTree, setSelectedTree] = useState(null);

  useEffect(() => {
    const fetchTrees = async () => {
      try {
        const response = await axios.get(
          "http://localhost:8080/trees/previous-trees"
        );
        setTrees(response.data);
      } catch (error) {
        setError("Error fetching data from backend");
        console.error(error);
      }
    };

    fetchTrees();
  }, []);

  return (
    <div className="min-h-screen p-4">
      <h1 className="text-2xl font-bold mb-4">Previous Trees</h1>
      {error && <p className="text-red-500">{error}</p>}
      <div className="space-y-4">
        {trees.map((tree, index) => (
          <div
            key={index}
            className="border rounded p-4 cursor-pointer"
            onClick={() => setSelectedTree(JSON.parse(tree.treeStructure))}
          >
            <p>
              <strong>Input Numbers:</strong>{" "}
              {JSON.stringify(tree.inputNumbers)}
            </p>
            <p>
              <strong>Tree Structure:</strong> (Click to view)
            </p>
          </div>
        ))}
      </div>
      {selectedTree && (
        <div className="mt-8">
          <h2 className="text-xl font-bold">Tree Visualization</h2>
          <TreeDiagram treeData={selectedTree} />
        </div>
      )}
    </div>
  );
};

export default HistoryPage;
