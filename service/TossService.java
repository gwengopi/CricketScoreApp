package home.projects.cricket.score.service;

import home.projects.cricket.score.dto.TossDTO;

public interface TossService {
    String getTossWinner(String matchId);
    String getTossDecision(String matchId);

    void saveTossDetails(TossDTO tossDetails);
}
