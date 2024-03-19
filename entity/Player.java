package home.projects.cricket.score.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "players")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    public Player(String playerName, String matchId){
        this.playerName = playerName;
        this.matchId = matchId;
    }

    @Id
    private String id;
    private String playerId; // Unique identifier for the player
    private String playerName;
    private String matchId; // Match the player is associated with
    private String team; // Team the player belongs to
    private int oversBowled; // Number of overs bowled by the player
    private int ballsBatted; // Number of balls faced by the player
    private int runsScored; // Total runs scored by the player
    private int runsConceded; // Total runs conceded by the player
    private int wicketsTaken; // Total wickets taken by the player
    private int catchesTaken; // Total catches taken by the player
    private int runOuts; // Total run-outs effected by the player
    private boolean isCaptain; // Indicates if the player is the captain of the team
    private boolean isWicketkeeper; // Indicates if the player is the wicketkeeper of the team

    // Batting stats
    private int boundaries; // Total boundaries (4s and 6s) scored by the player
    private double battingStrikeRate; // Batting strike rate
    private int timesDismissed; // Number of times dismissed

    // Bowling stats
    private double bowlingEconomyRate; // Bowling economy rate
    private double bowlingStrikeRate; // Bowling strike rate
    private int bestBowlingFigures; // Best bowling figures in the match
    private int maidenOversBowled; // Number of maiden overs bowled

    // Fielding stats
    private int stumpings; // Number of stumpings (if the player is a wicketkeeper)
    private int droppedCatches; // Number of dropped catches
    private String fieldingPositions; // Fielding position(s) played

    // Personal Information (optional)

    // private String dateOfBirth;
    // private String nationality;
    // private String role;

    // Constructors, getters, and setters
}
