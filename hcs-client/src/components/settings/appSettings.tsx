import React from "react";
import classNames from "classnames";

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
      <h2 id="settings-title">Settings:</h2>
      <div className="speed-control">
        <p>Current pace: {props.currentSpeed / 1000} seconds</p>
        <button
          onClick={() => props.updateSpeed(0.5)}
          className={classNames("speed-btn", {
            disabled: props.currentSpeed == 3000
          })}
        >
          Slower
        </button>
        <button
          onClick={() => props.updateSpeed(-0.5)}
          className={classNames("speed-btn", {
            disabled: props.currentSpeed == 500
          })}
        >
          Faster
        </button>
      </div>
      <div className="app-info-wrapper">
        <h2 id="app-title">"Half Court Simulator"</h2>
        <div className="app-info">
          <p>
            <b>About: </b>
            Two simultaneous simulations race against each other to be the first
            one to complete all four shots in succession. They will start on
            opposite ends of the challenge. (Half Court and Layup).
          </p>
          <p>
            <b>Goal: </b>
            With this simulation, viewers can see which process has the higher
            success rate.
          </p>
          <p>
            <b>Shot Success Percents: </b>
            <ul>
              <li>Half Court {"=>"} 8.5%</li>
              <li>Three Pointer {"=>"} 27.5%</li>
              <li>Free Throw {"=>"} 66%</li>
              <li>Layup {"=>"} 96%</li>
            </ul>
          </p>
        </div>
      </div>
    </div>
  );
};
