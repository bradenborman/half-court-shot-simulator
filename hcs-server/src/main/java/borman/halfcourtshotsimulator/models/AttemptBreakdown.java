package borman.halfcourtshotsimulator.models;

import java.util.ArrayList;

public class AttemptBreakdown {

    private ArrayList<ShotLocation> shotsAttemptedCurrentTry = new ArrayList<>();

    public void addShotHistory(ShotLocation attempted) {
        shotsAttemptedCurrentTry.add(attempted);
    }

    public ArrayList<ShotLocation> getShotsAttemptedCurrentTry() {
        return shotsAttemptedCurrentTry;
    }

    public void setShotsAttemptedCurrentTry(ArrayList<ShotLocation> shotsAttemptedCurrentTry) {
        this.shotsAttemptedCurrentTry = shotsAttemptedCurrentTry;
    }

}