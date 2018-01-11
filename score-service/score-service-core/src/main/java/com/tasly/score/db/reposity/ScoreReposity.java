package com.tasly.score.db.reposity;

import com.tasly.score.db.domain.Score;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dulei on 18/1/8.
 */
public interface ScoreReposity extends JpaRepository<Score,Long> {

}
