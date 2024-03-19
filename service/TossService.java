package home.projects.cricket.score.service;

public interface TossService {
    String getTossWinner(String matchId);
    String getTossDecision(String matchId);
}
