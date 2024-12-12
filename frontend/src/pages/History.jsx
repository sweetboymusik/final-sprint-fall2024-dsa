import React, { useState, useEffect } from "react";
import axios from "axios";
import TreeDiagram from "../components/TreeDiagram";
import Page from "../components/Page";
import PreviousTreeItem from "../components/PreviousTreeItem";

function History() {
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

  useEffect(() => {
    document.title = "All Trees";
  }, []);

  return (
    <Page label={"All Trees"}>
      <div className="flex justify-between gap-16 h-full">
        <div className="flex flex-col gap-8 flex-1">
          <h2>Tree List</h2>

          {error && <p className="text-red-500">{error}</p>}

          <div className="flex flex-col gap-2 overflow-y-auto border rounded p-4 h-[800px]">
            {trees.map((tree, index) => (
              <PreviousTreeItem
                key={tree.id}
                tree={tree}
                index={index}
                onClick={setSelectedTree}
              />
            ))}
          </div>
        </div>

        <div className="flex flex-col gap-8 flex-1">
          <h2>Tree Visualization</h2>
          {selectedTree && (
            <div className="border rounded h-full">
              <TreeDiagram treeData={selectedTree} />
            </div>
          )}
        </div>
      </div>
    </Page>
  );
}

export default History;
