package borman.halfcourtshotsimulator.services;

import borman.halfcourtshotsimulator.models.SimulationResult;
import borman.halfcourtshotsimulator.models.responses.SimulationResponse;
import org.springframework.stereotype.Service;

@Service
public class ShotSimulatorApplicationService {

    private SimulationService simulationService;
    private GameHistory gameHistory;

    public ShotSimulatorApplicationService(SimulationService simulationService, GameHistory gameHistory) {
        this.simulationService = simulationService;
        this.gameHistory = gameHistory;
    }

    public SimulationResponse startSimulationAndPopulateData(String[] startingLocations) {
        SimulationResponse simulationResponse = simulationService.startSequenceFromAll(startingLocations);
        simulationResponse.getAllResults().forEach(this::setAverage);
        return simulationResponse;
    }

    private void setAverage(SimulationResult x) {
        x.setAverageAttemptsUntilSuccess(
                gameHistory.populateAverageAttemptsByBreakdown(x.getStartingLocation())
        );
    }

}