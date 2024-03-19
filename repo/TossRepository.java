package home.projects.cricket.score.repo;
import home.projects.cricket.score.entity.Toss;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TossRepository extends MongoRepository<Toss, String> {
    Toss findByMatchId(String matchId);
}

