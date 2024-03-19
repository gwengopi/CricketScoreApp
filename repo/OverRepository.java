package home.projects.cricket.score.repo;

import home.projects.cricket.score.entity.Over;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OverRepository extends MongoRepository<Over, String> {
    Over findByMatchIdAndTeam(String matchId, String team);
}

