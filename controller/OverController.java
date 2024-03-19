package home.projects.cricket.score.controller;

import home.projects.cricket.score.dto.OverDTO;
import home.projects.cricket.score.entity.Over;
import home.projects.cricket.score.service.OverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/overs")
public class OverController {

    @Autowired
    private OverService overService;

    @PostMapping("/log")
    public ResponseEntity<Over> logBall(@RequestBody OverDTO overDTO) {
        try {
            Over over = overService.logBall(overDTO);
            return ResponseEntity.ok(over);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
