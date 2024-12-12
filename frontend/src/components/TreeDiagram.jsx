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

const renderCustomNode = ({ nodeDatum, foreignObjectProps }) => (
  <g>
    <rect
      width="120"
      height="40"
      x="-60"
      rx="4"
      ry="4"
      className="fill-primary-800 rounded border-none"
    />

    <foreignObject {...foreignObjectProps} className="">
      <div className="flex justify-center items-center w-[120px] h-[40px]">
        <span className="text-white">{nodeDatum.name}</span>{" "}
      </div>
    </foreignObject>
  </g>
);

function TreeDiagram({ treeData }) {
  const transformedData = transformTreeData(treeData);
  const nodeSize = { x: 200, y: 200 };
  const foreignObjectProps = {
    width: nodeSize.x,
    height: nodeSize.y,
    x: -60,
  };

  return (
    <>
      {transformedData ? (
        <Tree
          renderCustomNodeElement={(rd3tProps) =>
            renderCustomNode({ ...rd3tProps, foreignObjectProps })
          }
          data={transformedData}
          orientation="vertical"
          pathFunc="step"
          translate={{ x: 500, y: 100 }}
        />
      ) : (
        <p>No tree data available</p>
      )}
    </>
  );
}

export default TreeDiagram;
