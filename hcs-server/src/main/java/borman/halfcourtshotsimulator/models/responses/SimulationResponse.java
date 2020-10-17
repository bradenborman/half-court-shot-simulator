package borman.halfcourtshotsimulator.models.responses;

import borman.halfcourtshotsimulator.models.AttemptBreakdown;

import java.util.List;

public class SimulationResponse {

    private String startingLocation;
    private List<AttemptBreakdown> allAttempts;

    public String getStartingLocation() {
        return startingLocation;
    }

    public void setStartingLocation(String startingLocation) {
        this.startingLocation = startingLocation;
    }

    public List<AttemptBreakdown> getAllAttempts() {
        return allAttempts;
    }

    public void setAllAttempts(List<AttemptBreakdown> allAttempts) {
        this.allAttempts = allAttempts;
    }

}