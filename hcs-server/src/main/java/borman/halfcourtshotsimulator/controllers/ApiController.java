package borman.halfcourtshotsimulator.controllers;

import borman.halfcourtshotsimulator.models.requests.SimulationRequest;
import borman.halfcourtshotsimulator.models.responses.SimulationResponse;
import borman.halfcourtshotsimulator.services.SimulationService;
import borman.halfcourtshotsimulator.models.ShotLocation;
import borman.halfcourtshotsimulator.models.SimulationResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    private SimulationService simulationService;

    public ApiController(SimulationService simulationService) {
        this.simulationService = simulationService;
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

    @GetMapping("/simulate/start:free-throw")
    public ResponseEntity<SimulationResponse> simulateSequenceFromFreeThrow() {
        return ResponseEntity.ok(simulationService.startSequenceFromAll(ShotLocation.FREE_THROW.name()));
    }

    @GetMapping("/simulate/start:three-pointer")
    public ResponseEntity<SimulationResponse> simulateSequenceFromThreePointer() {
        return ResponseEntity.ok(simulationService.startSequenceFromAll(ShotLocation.THREE_POINTER.name()));
    }

}