import React from "react";
import Tree from "react-d3-tree";

const transformTreeData = (node) => {
  if (!node) return null;
  return {
    name: node.value.toString(),
    children: [
      transformTreeData(node.left),
      transformTreeData(node.right),
    ].filter(Boolean),
  };
};

function TreeDiagram({ treeData }) {
  const transformedData = transformTreeData(treeData);

  return (
    <div style={{ width: "100%", height: "500px" }}>
      {transformedData ? (
        <Tree
          data={transformedData}
          orientation="vertical"
          translate={{ x: 200, y: 50 }}
          pathFunc="step"
        />
      ) : (
        <p>No tree data available</p>
      )}
    </div>
  );
}

export default TreeDiagram;
