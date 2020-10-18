import React, { useState, useEffect } from "react";
import { SimulationResult } from "../../models/simulationResult";
import { AttemptBreakdown } from "../../models/attemptBreakdown";

require("./basketballCourt.scss");

export interface IBasketballCourtProps {
  simulationResult: SimulationResult;
}

export const BasketballCourt: React.FC<IBasketballCourtProps> = (
  props: IBasketballCourtProps
) => {
  const [currentLoction, setCurrentLocation] = useState<String | null>(
    props.simulationResult.startingLocation.replace("_", " ")
  );
  const [currentIndex, setCurrentIndex] = useState<number>(0);
  const [cycleCompleted, setCycleCompleted] = useState<boolean>(false);

  useEffect(() => {
    cycleThrough();
  }, [cycleCompleted]);

  const cycleThrough = async () => {
    await timeout(500); //for half sec delay
    const attemptBreakdown: AttemptBreakdown =
      props.simulationResult.allAttempts[currentIndex];
    const shots: String[] = attemptBreakdown.shotsAttemptedCurrentTry.map(
      shot => {
        return shot.replace("_", " ");
      }
    );

    const completed = updateShot(shots);
    setCurrentIndex(currentIndex + 1);
    setCycleCompleted(!cycleCompleted);
  };

  function timeout(delay: number) {
    return new Promise(res => setTimeout(res, delay));
  }

  const updateShot = async (shots: String[]) => {
    shots.forEach(shot => {
      setCurrentLocation(shot);
    });
    return true;
  };

  return (
    <div className="basketball-court">
      <div className="court-img"></div>

      <div className="data-display">
        <p className="starting-location-text">
          Starting from:{" "}
          {props.simulationResult.startingLocation.replace("_", " ")}
        </p>
        <p>Attempting shot from: {currentLoction}</p>
      </div>
    </div>
  );
};
