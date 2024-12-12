import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import Page from "../components/Page";
import Button from "../components/Button";

function Input() {
  const [numbers, setNumbers] = useState("");
  const [error, setError] = useState(null);
  const navigate = useNavigate();

  const handleSubmit = async () => {
    try {
      const parsedNumbers = JSON.parse(numbers);
      const response = await axios.post(
        "http://localhost:8080/trees/process-numbers",
        parsedNumbers,
        {
          headers: { "Content-Type": "application/json" },
        }
      );
      console.log("Tree created:", response.data);
      navigate("/previous-trees");
    } catch (err) {
      setError("Invalid input or error connecting to the backend");
      console.error(err);
    }
  };

  return (
    <Page label={"New Tree"}>
      <>
        <h2>Enter Numbers</h2>
        <textarea
          className="border rounded p-2 w-1/2 h-24"
          value={numbers}
          onChange={(e) => setNumbers(e.target.value)}
          placeholder="Enter numbers in JSON array format (e.g., [10, 5, 15, 3, 7])"
        />

        {error && <p className="text-red-500 mt-2">{error}</p>}

        <Button label={"Submit"} icon="add" onClick={handleSubmit} />
      </>
    </Page>
  );
}

export default Input;
