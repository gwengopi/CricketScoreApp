package home.projects.cricket.score.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ScoreDTO {

    private String matchId;
    private String team;
    private int runs;
    private int wickets;
    private double overs;
}
