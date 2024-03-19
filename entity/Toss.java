package home.projects.cricket.score.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tosses")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Toss {

    @Id
    private String id;
    private String matchId;
    private String winner;
    private String decision;

    // Getters and setters
}

