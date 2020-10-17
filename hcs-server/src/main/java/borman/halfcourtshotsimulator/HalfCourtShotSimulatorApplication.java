package borman.halfcourtshotsimulator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class HalfCourtShotSimulatorApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(HalfCourtShotSimulatorApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(HalfCourtShotSimulatorApplication.class);
	}

}