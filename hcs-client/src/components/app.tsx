import React, { useState, useEffect } from "react";
import axios from "axios";

import { SimulationResponse } from "../models/simulationResponse";
import { StartingLocation } from "../models/enums/StartingLocation";
import { AttemptBreakdown } from "../models/attemptBreakdown";

require("./app.scss");

export interface IAppProps {}

export const App: React.FC<IAppProps> = (props: IAppProps) => {
  const [
    halfCourtStartSimulation,
    SetHalfCourtStartSimulation
  ] = useState<SimulationResponse | null>(null);
  const [
    layupStartSimulation,
    SetLayupStartSimulation
  ] = useState<SimulationResponse | null>(null);

  useEffect(() => {
    fetchHalfCourtAttemptData();
    fetchLayupAttemptData();
  }, []);

  const fetchHalfCourtAttemptData = async () => {
    try {
      const res: any = await axios.post(`/api/simulate`, {
        startingLocation: StartingLocation.HALF_COURT
      });
      if (res.data) SetHalfCourtStartSimulation(res.data);
    } catch (err) {
      console.error(err);
    }
  };

  const fetchLayupAttemptData = async () => {
    try {
      const res: any = await axios.post(`/api/simulate`, {
        startingLocation: StartingLocation.LAYUP
      });
      if (res.data) SetLayupStartSimulation(res.data);
    } catch (err) {
      console.error(err);
    }
  };

  const displayData = (): JSX.Element | null => {
    if (halfCourtStartSimulation) {
      const items: JSX.Element[] = halfCourtStartSimulation.allAttempts
        .map((attempt: AttemptBreakdown) => {
          return attempt.shotsAttemptedCurrentTry;
        })
        .map((shot: String[]) => {
          return <p>{shot.concat(", ")}</p>;
        });

      return <div className="">{items}</div>;
    }

    return null;
  };

  return (
    <div>
      <p>{displayData()}</p>
    </div>
  );
};
