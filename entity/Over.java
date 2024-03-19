package home.projects.cricket.score.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "overs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Over {

    @Id
    private String id;
    private String matchId;
    private String team;
    private int runs;
    private int ballsBowled;
    private int wides;
    private int noBalls;
    private int totalRunsInOver;
    private int totalRunsInMatch;
    private int totalOversBowled;
    private int remainingOversToBowl;
    private int remainingBalls;
    private boolean isOverCompleted;
    private String battingTeam; // Added field to track batting team
    private String bowlingTeam; // Added field to track bowling team

    // Getters and setters
}
