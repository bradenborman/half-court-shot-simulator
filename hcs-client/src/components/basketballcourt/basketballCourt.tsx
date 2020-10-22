import React, { useState, useEffect } from "react";
import { SimulationResult } from "../../models/simulationResult";
import { AttemptBreakdown } from "../../models/attemptBreakdown";
import classNames from "classnames";

require("./basketballCourt.scss");

export interface IBasketballCourtProps {
  simulationResult: SimulationResult;
  playbackSpeend: number;
}

export const BasketballCourt: React.FC<IBasketballCourtProps> = (
  props: IBasketballCourtProps
) => {
  const [
    attemptedShotsThisTurn,
    setAttemptedShotsThisTurn
  ] = useState<String | null>(
    props.simulationResult.startingLocation.replace("_", " ")
  );
  const [currentIndex, setCurrentIndex] = useState<number>(0);
  const [cycleCompleted, setCycleCompleted] = useState<boolean>(false);
  const [shotIndexForIteration, setShotIndexForIteration] = useState<number>(0);

  useEffect(() => {
    cycleThrough();
  }, [cycleCompleted]);

  const cycleThrough = async () => {
    const attemptBreakdown: AttemptBreakdown =
      props.simulationResult.allAttempts[currentIndex];

    const shots: String[] = attemptBreakdown.shotsAttemptedCurrentTry.map(
      shot => {
        return shot.replace("_", " ");
      }
    );

    const completed = updateShot(shots);
    await timeout(props.playbackSpeend);
    setCurrentIndex(currentIndex + 1);
    setCycleCompleted(!cycleCompleted);
  };

  function timeout(delay: number) {
    return new Promise(res => setTimeout(res, delay));
  }

  const updateShot = (shots: String[]) => {
    setAttemptedShotsThisTurn(shots.join("**"));
    setShotIndexForIteration(shots.length);
    return true;
  };

  const getAttemptedShot = (): JSX.Element[] | JSX.Element | null => {
    if (attemptedShotsThisTurn)
      return attemptedShotsThisTurn.split("**").map(shot => {
        return <p>{shot}</p>;
      });

    return null;
  };

  const getCompletedTxt = (): JSX.Element | null => {
    if (props.simulationResult.allAttempts.length == currentIndex)
      return <p className="completedTxt">Completed!</p>;
    return null;
  };

  const getCurrentImg = () => {
    if (props.simulationResult.allAttempts.length <= currentIndex)
      return <div className={classNames("court-img", "completed")}></div>;

    if (shotIndexForIteration == 1)
      return <div className={classNames("court-img", "first-step")}></div>;

    if (shotIndexForIteration == 2)
      return <div className={classNames("court-img", "second-step")}></div>;

    if (shotIndexForIteration == 3)
      return <div className={classNames("court-img", "third-step")}></div>;

    if (shotIndexForIteration == 4)
      return <div className={classNames("court-img", "fourth-step")}></div>;

    return <div className={classNames("court-img", "first-step")}></div>;
  };

  return (
    <div className="basketball-court">
      <div className="avg-display">
        AVG: {props.simulationResult.averageAttemptsUntilSuccess}
      </div>
      {getCurrentImg()}
      <div className="data-display">
        <p className="starting-location-text">
          Starting from:{" "}
          {props.simulationResult.startingLocation.replace("_", " ")}
        </p>
        <p>
          <span className="headerTxt">Attempting sequence:</span> {currentIndex}
        </p>
        <p>
          <span className="headerTxt">Attempted shots from:</span>
        </p>
        {getAttemptedShot()}
        <div>{getCompletedTxt()}</div>
      </div>
    </div>
  );
};
