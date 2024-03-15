package home.projects.cricket.score.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "scores")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Score {

    @Id
    private String id;
    private String matchId;
    private String team;
    private int runs;
    private int wickets;
    private double overs;

    // Getters and setters
}
