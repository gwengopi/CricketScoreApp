package home.projects.cricket.score.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OverDTO {
    private String matchId;
    private String team;
    private int runs;
    private boolean isWide;
    private boolean isNoBall;

    // Getters and setters
}

