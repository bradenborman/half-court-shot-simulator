package borman.halfcourtshotsimulator.models;

import borman.halfcourtshotsimulator.exceptions.InvalidStartingLocation;

import java.util.*;
import java.util.stream.Collectors;

public enum ShotLocation {

    HALF_COURT(85),
    THREE_POINTER(275),
    FREE_THROW(666),
    LAYUP(960);

    private final int oddsOfSuccess;

    ShotLocation(int oddsOfSuccess) {
        this.oddsOfSuccess = oddsOfSuccess;
    }

    private static final List<ShotLocation> shotOrder = Arrays.asList(HALF_COURT, THREE_POINTER, FREE_THROW, LAYUP);

    public boolean attemptShot() {
        return (new Random().nextInt(1000 - 1) + 1) <= oddsOfSuccess;
    }

    public static List<ShotLocation> getShotSequence(String startingSpotStr) {

        ShotLocation startingSpot = ShotLocation.valueOf(startingSpotStr);

        if (startingSpot == ShotLocation.HALF_COURT)
            return shotOrder;

        else if (startingSpot == ShotLocation.LAYUP)
            return shotOrder.stream()
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList());

        throw new InvalidStartingLocation("Invalid starting location. " + startingSpot.name() + " was chosen.");
    }

}