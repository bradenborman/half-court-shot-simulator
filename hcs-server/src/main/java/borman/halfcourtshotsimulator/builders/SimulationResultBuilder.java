package borman.halfcourtshotsimulator.builders;

import borman.halfcourtshotsimulator.models.AttemptBreakdown;
import borman.halfcourtshotsimulator.models.SimulationResult;

import java.util.List;

public final class SimulationResultBuilder {

    private SimulationResult simulationResult;

    private SimulationResultBuilder() {
        simulationResult = new SimulationResult();
    }

    public static SimulationResultBuilder aSimulationResult() {
        return new SimulationResultBuilder();
    }

    public SimulationResultBuilder withStartingLocation(String startingLocation) {
        simulationResult.setStartingLocation(startingLocation);
        return this;
    }

    public SimulationResultBuilder withAllAttempts(List<AttemptBreakdown> allAttempts) {
        simulationResult.setAllAttempts(allAttempts);
        return this;
    }

    public SimulationResult build() {
        return simulationResult;
    }

}