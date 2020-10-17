package borman.halfcourtshotsimulator.services;


import borman.halfcourtshotsimulator.builders.SimulationResponseBuilder;
import borman.halfcourtshotsimulator.models.AttemptBreakdown;
import borman.halfcourtshotsimulator.models.ShotLocation;
import borman.halfcourtshotsimulator.models.responses.SimulationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class SimulationService {

    private Logger logger = LoggerFactory.getLogger(SimulationService.class);

    public SimulationResponse startSequenceFrom(String startingPoint) {
        logger.info("Starting shot process from: {}", startingPoint);

        List<AttemptBreakdown> attemptBreakdown = simulate(
                ShotLocation.getShotSequence(startingPoint)
        );

        return SimulationResponseBuilder.aSimulationResponse()
                .withAllAttempts(attemptBreakdown)
                .withStartingLocation(startingPoint)
                .build();

    }

    List<AttemptBreakdown> simulate(List<ShotLocation> shotsToTake) {

        List<AttemptBreakdown> attempts = new ArrayList<>();
        AtomicBoolean completedProcess = new AtomicBoolean(false);

        do {
            AtomicBoolean lastShotSuccess = new AtomicBoolean(true);
            do {
                lastShotSuccess.set(true);
                logger.debug("Starting new Attempt: {}", attempts.size());
                AttemptBreakdown attemptBreakdown = new AttemptBreakdown();
                shotsToTake.forEach(spotToShot -> {
                    if (lastShotSuccess.get()) {
                        boolean shotStatus = spotToShot.attemptShot();
                        attemptBreakdown.addShotHistory(spotToShot);
                        logger.debug("Last shot from {} was {}.", spotToShot.name(), shotStatus ? "made" : "missed");
                        lastShotSuccess.set(shotStatus);
                    }
                });
                attempts.add(attemptBreakdown);
            } while (!lastShotSuccess.get());

            completedProcess.set(true);
        }
        while (!completedProcess.get());

        logger.info("Process completed from start to finish after {} attemps\n", attempts.size());
        return attempts;
    }

}