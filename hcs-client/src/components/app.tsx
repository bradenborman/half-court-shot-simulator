import React, { useState, useEffect } from "react";
import axios from "axios";

import { StartingLocation } from "../models/enums/StartingLocation";
import { SimulationResponse } from "../models/simulationResponse";
import { SimulationRequest } from "../models/simulationRequest";
import { BasketballCourt } from "./basketballcourt/basketballCourt";
import { SimulationResult } from "../models/simulationResult";
import { AppSettings } from "./settings/appSettings";
import { ContextMenu } from "./context-menu/ContextMenu";
import { MenuItem } from "./context-menu/menuItem";
import { MenuSeparator } from "./context-menu/menuSeparator";
import { openGoogle, reloadPage } from "./context-menu/menuActions";

require("./app.scss");

export interface IAppProps {}

export const App: React.FC<IAppProps> = (props: IAppProps) => {
  const [
    fullSimulationResponse,
    setFullSimulationResponse
  ] = useState<SimulationResponse | null>(null);

  const [playSpeed, setPlaySpeed] = useState<number>(1500);

  useEffect(() => {
    fetcAttemptData();
  }, []);

  const fetcAttemptData = async () => {
    const requestBody: SimulationRequest = {
      startingLocations: [StartingLocation.HALF_COURT, StartingLocation.LAYUP]
    };
    try {
      const res: any = await axios.post(`/api/simulate`, requestBody);
      if (res.data) {
        const response: SimulationResponse = res.data;
        setFullSimulationResponse(response);
      }
    } catch (err) {
      console.error(err);
    }
  };

  const getCourts = (): JSX.Element[] | JSX.Element | null => {
    if (fullSimulationResponse) {
      return fullSimulationResponse.allResults.map(
        (simulation: SimulationResult, index: number) => {
          return (
            <BasketballCourt
              key={index}
              simulationResult={simulation}
              playbackSpeend={playSpeed}
            />
          );
        }
      );
    }
    return null;
  };

  const updateSpeed = (speedModifier: number) => {
    speedModifier = speedModifier * 1000;
    if (
      (speedModifier < 0 && playSpeed >= 1000) ||
      (speedModifier > 0 && playSpeed <= 2500)
    )
      setPlaySpeed(playSpeed + speedModifier);
  };

  const getContextMenu = (): JSX.Element => {
    return (
      <ContextMenu>
        {/* <ContextMenu allowedClasses={["basketball-court"]}> */}
        <MenuItem action={openGoogle} iconClass="fa-google">
          Open Google Search
        </MenuItem>
        <MenuItem disabled={true}>Demo link 2 - disabled</MenuItem>
        <MenuItem disabled={true}>Demo link 3 - disabled</MenuItem>
        <MenuSeparator />
        <MenuItem action={reloadPage} iconClass="fa-refresh">
          Refresh Page
        </MenuItem>
      </ContextMenu>
    );
  };

  return (
    <div className="app-wrapper">
      <AppSettings currentSpeed={playSpeed} updateSpeed={updateSpeed} />
      {getCourts()}
      {getContextMenu()}
    </div>
  );
};
