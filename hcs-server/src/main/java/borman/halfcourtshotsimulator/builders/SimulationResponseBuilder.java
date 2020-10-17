package borman.halfcourtshotsimulator.builders;

import borman.halfcourtshotsimulator.models.AttemptBreakdown;
import borman.halfcourtshotsimulator.models.responses.SimulationResponse;

import java.util.List;

public final class SimulationResponseBuilder {

    private SimulationResponse simulationResponse;

    private SimulationResponseBuilder() {
        simulationResponse = new SimulationResponse();
    }

    public static SimulationResponseBuilder aSimulationResponse() {
        return new SimulationResponseBuilder();
    }

    public SimulationResponseBuilder withAllAttempts(List<AttemptBreakdown> allAttempts) {
        simulationResponse.setAllAttempts(allAttempts);
        return this;
    }

    public SimulationResponseBuilder withStartingLocation(String startingLocation) {
        simulationResponse.setStartingLocation(startingLocation);
        return this;
    }

    public SimulationResponse build() {
        return simulationResponse;
    }

}