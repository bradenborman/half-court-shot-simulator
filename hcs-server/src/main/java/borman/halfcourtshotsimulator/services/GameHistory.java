package borman.halfcourtshotsimulator.services;

import borman.halfcourtshotsimulator.daos.GameHistoryDao;
import org.springframework.stereotype.Service;

@Service
public class GameHistory {

    private GameHistoryDao gameHistoryDao;

    public GameHistory(GameHistoryDao gameHistoryDao) {
        this.gameHistoryDao = gameHistoryDao;
    }


    public String populateAverageAttemptsByBreakdown(String location) {
        return gameHistoryDao.getAverageShotsToSuccessByLocation(location);
    }

}