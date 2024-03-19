package home.projects.cricket.score.service;

import home.projects.cricket.score.dto.OverDTO;
import home.projects.cricket.score.entity.Over;

public interface OverService {
    Over logBall(OverDTO overDTO);
}

