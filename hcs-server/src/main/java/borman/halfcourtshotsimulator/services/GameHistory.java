package borman.halfcourtshotsimulator.services;

import borman.halfcourtshotsimulator.daos.GameHistoryDao;
import borman.halfcourtshotsimulator.models.ShotLocation;
import borman.halfcourtshotsimulator.models.responses.AverageBreakdown;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class GameHistory {

    private GameHistoryDao gameHistoryDao;

    public GameHistory(GameHistoryDao gameHistoryDao) {
        this.gameHistoryDao = gameHistoryDao;
    }

    public List<AverageBreakdown> selectAverages() {
        List<AverageBreakdown> breakdownList = Arrays.asList(
                new AverageBreakdown(ShotLocation.HALF_COURT),
                new AverageBreakdown(ShotLocation.LAYUP)
        );
        breakdownList.forEach(this::populateAverageAttemptsByBreakdown);
        return breakdownList;

    }

    private void populateAverageAttemptsByBreakdown(AverageBreakdown averageBreakdown) {
        averageBreakdown.setAverageAttemptsUntilSuccess(
                gameHistoryDao.getAverageShotsToSuccessByLocation(averageBreakdown.getStartingPosition())
        );
    }

}