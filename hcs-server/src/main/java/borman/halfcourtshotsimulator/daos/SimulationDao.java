package borman.halfcourtshotsimulator.daos;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import static borman.halfcourtshotsimulator.daos.Queries.*;

@Component
public class SimulationDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public SimulationDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    public void insertSimulation(int attempts, String location) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("startingPosition", location);
        params.addValue("attempts", attempts);
        namedParameterJdbcTemplate.update(INSERT_SIMULATION, params);
    }

}