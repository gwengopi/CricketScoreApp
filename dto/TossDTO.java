package home.projects.cricket.score.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TossDTO {

    private String matchId;
    private String winner;
    private String decision;
}
