import { AttemptBreakdown } from "./attemptBreakdown";

export interface SimulationResult {
  startingLocation: string;
  allAttempts: AttemptBreakdown[];
}
