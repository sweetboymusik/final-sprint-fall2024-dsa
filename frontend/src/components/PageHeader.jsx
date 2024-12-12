import React from "react";

function PageHeader({ label, Button, SecondaryButton }) {
  return (
    <div className="flex p-6 h-28 gap-16 items-center">
      <div className="flex flex-col gap-2">
        <h1>{label}</h1>
      </div>

      <div className="flex gap-6">
        {Button}
        {SecondaryButton}
      </div>
    </div>
  );
}

export default PageHeader;
