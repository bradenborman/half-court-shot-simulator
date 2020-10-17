package borman.halfcourtshotsimulator.builders;

import borman.halfcourtshotsimulator.models.SimulationResult;
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

    public SimulationResponseBuilder withAllResults(List<SimulationResult> allResults) {
        simulationResponse.setAllResults(allResults);
        return this;
    }

    public SimulationResponse build() {
        return simulationResponse;
    }

}