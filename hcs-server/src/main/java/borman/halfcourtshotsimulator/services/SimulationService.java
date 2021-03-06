package borman.halfcourtshotsimulator.services;

import borman.halfcourtshotsimulator.builders.SimulationResponseBuilder;
import borman.halfcourtshotsimulator.builders.SimulationResultBuilder;
import borman.halfcourtshotsimulator.daos.SimulationDao;
import borman.halfcourtshotsimulator.models.AttemptBreakdown;
import borman.halfcourtshotsimulator.models.ShotLocation;
import borman.halfcourtshotsimulator.models.SimulationResult;
import borman.halfcourtshotsimulator.models.responses.SimulationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SimulationService {

    private Logger logger = LoggerFactory.getLogger(SimulationService.class);
    private SimulationDao simulationDao;

    public SimulationService(SimulationDao simulationDao) {
        this.simulationDao = simulationDao;
    }

    public SimulationResponse startSequenceFromAll(String... startingPoint) {
        List<SimulationResult> allResults = Stream.of(startingPoint)
                .map(this::startSequenceFrom)
                .collect(Collectors.toList());

        logger.info("Request Completed\n");
        return SimulationResponseBuilder.aSimulationResponse()
                .withAllResults(allResults)
                .build();
    }

    private SimulationResult startSequenceFrom(String startingPoint) {
        logger.info("Starting shot process from: {}", startingPoint);
        SimulationResult result = SimulationResultBuilder.aSimulationResult()
                .withAllAttempts(
                        simulate(
                                ShotLocation.getShotSequence(startingPoint)
                        )
                )
                .withStartingLocation(startingPoint)
                .build();

        simulationDao.insertSimulation(result.getAllAttempts().size(), result.getStartingLocation());

        return result;
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

        logger.info("Process completed from start to finish after {} attempts", attempts.size());
        return attempts;
    }

    public void initData() {
        logger.info("Inserting simulations..");
        for (int i = 0; i < 10; i++) {
            this.startSequenceFrom(ShotLocation.HALF_COURT.name());
            this.startSequenceFrom(ShotLocation.LAYUP.name());
        }
    }

}