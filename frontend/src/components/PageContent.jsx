import React from "react";

function PageContent({ children }) {
  return <div className="flex flex-col px-6 gap-8">{children}</div>;
}

export default PageContent;
