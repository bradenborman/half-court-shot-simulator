package borman.halfcourtshotsimulator.controllers;

import borman.halfcourtshotsimulator.models.requests.SimulationRequest;
import borman.halfcourtshotsimulator.models.responses.AverageBreakdown;
import borman.halfcourtshotsimulator.models.responses.SimulationResponse;
import borman.halfcourtshotsimulator.services.GameHistory;
import borman.halfcourtshotsimulator.services.SimulationService;
import borman.halfcourtshotsimulator.models.ShotLocation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private SimulationService simulationService;
    private GameHistory gameHistory;

    public ApiController(SimulationService simulationService, GameHistory gameHistory) {
        this.simulationService = simulationService;
        this.gameHistory = gameHistory;
    }

    @PostMapping("/simulate")
    public ResponseEntity<SimulationResponse> simulateSequence(@RequestBody SimulationRequest simulationRequest) {
        return ResponseEntity.ok(simulationService.startSequenceFromAll(simulationRequest.getStartingLocations()));
    }

    @GetMapping("/simulate/start:half-court")
    public ResponseEntity<SimulationResponse> simulateSequenceFromHalfCort() {
        return ResponseEntity.ok(simulationService.startSequenceFromAll(ShotLocation.HALF_COURT.name()));
    }

    @GetMapping("/simulate/start:lay-up")
    public ResponseEntity<SimulationResponse> simulateSequenceFromLayup() {
        return ResponseEntity.ok(simulationService.startSequenceFromAll(ShotLocation.LAYUP.name()));
    }

    @GetMapping("/game-history-averages")
    public ResponseEntity<List<AverageBreakdown>> selectAverages() {
        return ResponseEntity.ok(gameHistory.selectAverages());
    }

}