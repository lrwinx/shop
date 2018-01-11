package com.tasly.score.db.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * Created by dulei on 18/1/8.
 */
@Data
@Entity
public class Score {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Long uid;

    /**
     * 总积分
     */
    private Integer totalScore;
}
