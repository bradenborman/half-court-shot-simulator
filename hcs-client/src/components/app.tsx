import React, { useState, useEffect } from "react";
import Spinner from "react-bootstrap/Spinner";

import {
  BrowserRouter as ReactRouter,
  Route as ReactRoute
} from "react-router-dom";


require("./app.scss");

export interface IAppProps {}

export const App: React.FC<IAppProps> = (props: IAppProps) => {

  useEffect(() => {}, []);

  return (
    <div>
      <p>Test</p>
    </div>
  );
};
