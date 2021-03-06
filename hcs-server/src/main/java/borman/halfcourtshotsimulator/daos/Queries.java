package borman.halfcourtshotsimulator.daos;

public class Queries {

    final static String SELECT_SHOT_AVERAGE_BY_LOCATION =
            "SELECT AVG(shots_to_finish) " +
                    "FROM game_history " +
                    "WHERE starting_position = :startingPosition";


    final static String INSERT_SIMULATION =
            "INSERT INTO game_history (starting_position, shots_to_finish) " +
                    "VALUES (:startingPosition, :attempts)";

}