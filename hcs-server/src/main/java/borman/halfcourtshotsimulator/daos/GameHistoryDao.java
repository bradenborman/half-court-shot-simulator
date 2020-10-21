package borman.halfcourtshotsimulator.daos;

import borman.halfcourtshotsimulator.models.ShotLocation;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import static borman.halfcourtshotsimulator.daos.Queries.*;

@Component
public class GameHistoryDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public GameHistoryDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public String getAverageShotsToSuccessByLocation(ShotLocation location) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("startingPosition", location.name());
        return namedParameterJdbcTemplate.queryForObject(SELECT_SHOT_AVERAGE_BY_LOCATION, params, String.class);
    }


}