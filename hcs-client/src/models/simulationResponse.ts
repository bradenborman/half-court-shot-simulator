import { AttemptBreakdown } from "./attemptBreakdown";

export interface SimulationResponse {
  startingLocation: string;
  allAttempts: AttemptBreakdown[];
}
