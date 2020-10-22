package borman.halfcourtshotsimulator.controllers;

import borman.halfcourtshotsimulator.models.requests.SimulationRequest;
import borman.halfcourtshotsimulator.models.responses.SimulationResponse;
import borman.halfcourtshotsimulator.services.ShotSimulatorApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {


    private ShotSimulatorApplicationService shotSimulatorApplicationService;

    public ApiController(ShotSimulatorApplicationService shotSimulatorApplicationService) {
        this.shotSimulatorApplicationService = shotSimulatorApplicationService;
    }

    @PostMapping("/simulate")
    public ResponseEntity<SimulationResponse> simulateSequence(@RequestBody SimulationRequest simulationRequest) {
        return ResponseEntity.ok(shotSimulatorApplicationService.startSimulationAndPopulateData(simulationRequest.getStartingLocations()));
    }

}