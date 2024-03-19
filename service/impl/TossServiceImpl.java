package home.projects.cricket.score.service.impl;

import home.projects.cricket.score.entity.Toss;
import home.projects.cricket.score.repo.TossRepository;
import home.projects.cricket.score.service.TossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TossServiceImpl implements TossService {

    @Autowired
    private TossRepository tossRepository;

    @Override
    public String getTossWinner(String matchId) {
        Toss toss = tossRepository.findByMatchId(matchId);
        if (toss != null) {
            return toss.getWinner();
        }
        return null;
    }

    @Override
    public String getTossDecision(String matchId) {
        Toss toss = tossRepository.findByMatchId(matchId);
        if (toss != null) {
            return toss.getDecision();
        }
        return null;
    }
}

