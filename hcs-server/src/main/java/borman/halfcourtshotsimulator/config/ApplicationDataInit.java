package borman.halfcourtshotsimulator.config;

import borman.halfcourtshotsimulator.services.SimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationDataInit implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    SimulationService simulationService;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        simulationService.initData();
    }

}