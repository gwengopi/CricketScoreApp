package home.projects.cricket.score.controller;

import home.projects.cricket.score.dto.TossDTO;
import home.projects.cricket.score.service.TossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/toss")
public class TossController {

    @Autowired
    private TossService tossService;
    @RequestMapping(value = "/getTossDetails")
    public ResponseEntity getTossDetails(@RequestParam String matchId){
        TossDTO tossDetails = new TossDTO();
        tossDetails.setWinner(tossService.getTossWinner(matchId));
        tossDetails.setDecision(tossService.getTossDecision(matchId));
        tossDetails.setMatchId(matchId);
        return ResponseEntity.ok(tossDetails);
    }

    @RequestMapping(value = "/saveTossDetails")
    public ResponseEntity saveTossDetails(@RequestBody TossDTO tossDetails){
       tossService.saveTossDetails(tossDetails);
        return ResponseEntity.ok(tossDetails);
    }

}
