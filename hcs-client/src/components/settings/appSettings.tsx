import React, { useState, useEffect } from "react";

require("./appSettings.scss");

export interface IAppSettingsProps {
  currentSpeed: number;
}

export const AppSettings: React.FC<IAppSettingsProps> = (
  props: IAppSettingsProps
) => {
  return (
    <div className="settings-wrapper">
      <h2>Settings:</h2>
      <div className="speed-control">
        <p>Current pace: {props.currentSpeed / 1000} seconds</p>
        <div className="speed-btn">Slower</div>
        <div className="speed-btn">Faster</div>
      </div>
    </div>
  );
};
