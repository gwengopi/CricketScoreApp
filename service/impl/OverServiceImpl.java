package home.projects.cricket.score.service.impl;

import home.projects.cricket.score.dto.OverDTO;
import home.projects.cricket.score.dto.OverRepository;
import home.projects.cricket.score.entity.Over;
import home.projects.cricket.score.service.OverService;
import home.projects.cricket.score.service.TossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OverServiceImpl implements OverService {

    @Autowired
    private OverRepository overRepository;

    // Inject TossService if needed
    @Autowired
    private TossService tossService;

    @Override
    public Over logBall(OverDTO overDTO) {
        // Fetch toss details based on matchId
        String matchId = overDTO.getMatchId();
        String tossWinner = tossService.getTossWinner(matchId);
        String tossDecision = tossService.getTossDecision(matchId);

        Over over = overRepository.findByMatchIdAndTeam(matchId, tossWinner);

        if (over == null || over.isOverCompleted()) {
            over = new Over();
            over.setMatchId(matchId);
            over.setTeam(tossWinner);
            if ("bat".equalsIgnoreCase(tossDecision)) {
                over.setBattingTeam(tossWinner);
                over.setBowlingTeam("Opponent team"); // You need to implement logic to determine the opponent team
            } else {
                over.setBattingTeam("Opponent team");
                over.setBowlingTeam(tossWinner);
            }
            // Reset necessary fields for new over
            over.setRuns(overDTO.getRuns());
            over.setBallsBowled(1);
            over.setWides(overDTO.isWide() ? 1 : 0);
            over.setNoBalls(overDTO.isNoBall() ? 1 : 0);
            over.setTotalRunsInOver(overDTO.getRuns());
            over.setTotalRunsInMatch(overDTO.getRuns());
            over.setTotalOversBowled(over.getTotalOversBowled() + 1);
            over.setRemainingOversToBowl(50 - over.getTotalOversBowled());
            over.setRemainingBalls(6 - (over.getWides() + over.getNoBalls()));
            over.setOverCompleted(false);
        } else {
            over.setTotalRunsInOver(over.getTotalRunsInOver() + overDTO.getRuns());
            over.setTotalRunsInMatch(over.getTotalRunsInMatch() + overDTO.getRuns());

            // Update runs and other fields
            if (!overDTO.isWide() && !overDTO.isNoBall()) {
                over.setBallsBowled(over.getBallsBowled() + 1);
            }
            over.setRuns(over.getRuns() + (overDTO.isWide() || overDTO.isNoBall() ? 1 : overDTO.getRuns()));
            over.setWides(over.getWides() + (overDTO.isWide() ? 1 : 0));
            over.setNoBalls(over.getNoBalls() + (overDTO.isNoBall() ? 1 : 0));

            // Handle completion of over
            if (over.getBallsBowled() == 6) {
                over.setRemainingBalls(6);
                over.setTotalOversBowled(over.getTotalOversBowled() + 1);
                over.setRemainingOversToBowl(50 - over.getTotalOversBowled());
                over.setBallsBowled(0);
                over.setWides(0);
                over.setNoBalls(0);
                over.setTotalRunsInOver(0);
                over.setOverCompleted(true);
            } else {
                over.setRemainingBalls(6 - (over.getBallsBowled() + over.getWides() + over.getNoBalls()));
                over.setOverCompleted(false);
            }
        }

        overRepository.save(over);
        return over;
    }
}

