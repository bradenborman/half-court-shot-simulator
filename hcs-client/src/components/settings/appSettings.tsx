import React, { useState, useEffect } from "react";
import { update } from "lodash";

require("./appSettings.scss");

export interface IAppSettingsProps {
  currentSpeed: number;
  updateSpeed: (newTime: number) => void;
}

export const AppSettings: React.FC<IAppSettingsProps> = (
  props: IAppSettingsProps
) => {
  return (
    <div className="settings-wrapper">
      <h2>Settings:</h2>
      <div className="speed-control">
        <p>Current pace: {props.currentSpeed / 1000} seconds</p>
        <div onClick={() => props.updateSpeed(0.5)} className="speed-btn">
          Slower
        </div>
        <div onClick={() => props.updateSpeed(-0.5)} className="speed-btn">
          Faster
        </div>
      </div>
    </div>
  );
};
