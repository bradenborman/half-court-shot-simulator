package borman.halfcourtshotsimulator.models.responses;

import borman.halfcourtshotsimulator.models.SimulationResult;

import java.util.List;

public class SimulationResponse {

    private List<SimulationResult> allResults;

    public List<SimulationResult> getAllResults() {
        return allResults;
    }

    public void setAllResults(List<SimulationResult> allResults) {
        this.allResults = allResults;
    }

}