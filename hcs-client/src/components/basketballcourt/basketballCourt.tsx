import React, { useState, useEffect } from "react";
import { SimulationResult } from "../../models/simulationResult";

require("./basketballCourt.scss");

export interface IBasketballCourtProps {
  simulationResult: SimulationResult;
}

export const BasketballCourt: React.FC<IBasketballCourtProps> = (
  props: IBasketballCourtProps
) => {
  return (
    <div className="basketball-court">
      <div className="court-img"></div>

      <div className="data-display">
        <p className="starting-location-text">
          Starting from:{" "}
          {props.simulationResult.startingLocation.replace("_", " ")}
        </p>
      </div>
    </div>
  );
};
