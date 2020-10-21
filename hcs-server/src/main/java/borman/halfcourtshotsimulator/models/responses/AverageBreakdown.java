package borman.halfcourtshotsimulator.models.responses;

import borman.halfcourtshotsimulator.models.ShotLocation;

public class AverageBreakdown {

    private ShotLocation startingPosition;
    private String averageAttemptsUntilSuccess;

    public AverageBreakdown(ShotLocation startingPosition) {
        this.startingPosition = startingPosition;
    }

    public ShotLocation getStartingPosition() {
        return startingPosition;
    }

    public void setStartingPosition(ShotLocation startingPosition) {
        this.startingPosition = startingPosition;
    }

    public String getAverageAttemptsUntilSuccess() {
        return averageAttemptsUntilSuccess;
    }

    public void setAverageAttemptsUntilSuccess(String averageAttemptsUntilSuccess) {
        this.averageAttemptsUntilSuccess = averageAttemptsUntilSuccess;
    }

}