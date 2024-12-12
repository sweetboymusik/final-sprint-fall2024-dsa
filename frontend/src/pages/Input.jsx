import React, { useState, useEffect } from "react";
import axios from "axios";
import Page from "../components/Page";
import Button from "../components/Button";
import TreeDiagram from "../components/TreeDiagram";

function Input() {
  const [numbers, setNumbers] = useState("");
  const [error, setError] = useState(null);
  const [balance, setBalance] = useState(false);
  const [selectedTree, setSelectedTree] = useState(null);

  const handleSubmit = async () => {
    try {
      setError(null);

      const parsedNumbers = JSON.parse(numbers);

      let response;

      if (balance) {
        response = await axios.post(
          "http://localhost:8080/trees/process-and-balance",
          parsedNumbers,
          {
            headers: { "Content-Type": "application/json" },
          }
        );
      } else {
        response = await axios.post(
          "http://localhost:8080/trees/process-numbers",
          parsedNumbers,
          {
            headers: { "Content-Type": "application/json" },
          }
        );
      }

      setSelectedTree(JSON.parse(response.data.treeStructure));
    } catch (err) {
      setError("Invalid input or error connecting to the backend");
      console.error(err);
    }
  };

  const handleCheckboxChange = (event) => {
    setBalance(event.target.checked);
  };

  useEffect(() => {
    document.title = "New Tree";
  }, []);

  return (
    <Page label={"New Tree"}>
      <div className="flex gap-16 h-full">
        <div className="flex flex-col gap-8 flex-1">
          <h2>Enter Numbers</h2>
          <textarea
            className="border rounded p-2 h-24"
            value={numbers}
            onChange={(e) => setNumbers(e.target.value)}
            placeholder="Enter numbers in JSON array format (e.g., [10, 5, 15, 3, 7])"
          />

          <div className="flex gap-2">
            <input
              type="checkbox"
              id="checkbox"
              checked={balance}
              onChange={handleCheckboxChange}
            />
            <label htmlFor="checkbox">Balance</label>
          </div>

          {error && <p className="text-red-500 mt-2">{error}</p>}

          <Button label={"Submit"} icon="add" onClick={handleSubmit} />
        </div>

        <div className="flex flex-col gap-8 flex-1 h-[800px]">
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

export default Input;
