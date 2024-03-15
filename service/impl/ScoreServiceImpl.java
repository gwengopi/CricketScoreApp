package home.projects.cricket.score.service.impl;

import home.projects.cricket.score.dto.ScoreDTO;
import home.projects.cricket.score.entity.Score;
import home.projects.cricket.score.service.ScoreService;
import home.projects.cricket.score.repo.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    @Override
    public void logScore(ScoreDTO scoreDTO) {
        Score score = new Score();
        score.setMatchId(scoreDTO.getMatchId());
        score.setTeam(scoreDTO.getTeam());
        score.setRuns(scoreDTO.getRuns());
        score.setWickets(scoreDTO.getWickets());
        score.setOvers(scoreDTO.getOvers());
        scoreRepository.save(score);
    }
}
