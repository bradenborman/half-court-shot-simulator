package borman.halfcourtshotsimulator.daos;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import static borman.halfcourtshotsimulator.daos.Queries.SELECT_SHOT_AVERAGE_BY_LOCATION;

@Component
public class GameHistoryDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public GameHistoryDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public String getAverageShotsToSuccessByLocation(String location) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("startingPosition", location);
        return namedParameterJdbcTemplate.queryForObject(SELECT_SHOT_AVERAGE_BY_LOCATION, params, String.class);
    }

}