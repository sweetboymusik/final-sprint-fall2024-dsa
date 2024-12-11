import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

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
    <div className="flex flex-col items-center justify-center min-h-screen">
      <h1 className="text-2xl font-bold mb-4">Enter Numbers</h1>
      <textarea
        className="border rounded p-2 w-1/2 h-24"
        value={numbers}
        onChange={(e) => setNumbers(e.target.value)}
        placeholder="Enter numbers in JSON array format (e.g., [10, 5, 15, 3, 7])"
      />
      {error && <p className="text-red-500 mt-2">{error}</p>}
      <button
        className="mt-4 px-4 py-2 bg-blue-500 text-white rounded"
        onClick={handleSubmit}
      >
        Submit
      </button>
      <button
        className="mt-2 px-4 py-2 bg-gray-500 text-white rounded"
        onClick={() => navigate("/previous-trees")}
      >
        View Previous Trees
      </button>
    </div>
  );
}

export default Input;
