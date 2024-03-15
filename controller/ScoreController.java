package home.projects.cricket.score.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PostMapping("/score")
    public ResponseEntity<String> logScore(@RequestBody ScoreDTO scoreDTO) {
        try {
            scoreService.logScore(scoreDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Score logged successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to log score: " + e.getMessage());
        }
    }
}
