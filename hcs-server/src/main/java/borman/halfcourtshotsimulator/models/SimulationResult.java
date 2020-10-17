package borman.halfcourtshotsimulator.models;

import java.util.List;

public class SimulationResult {

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