package com.tasly.score.core;

import com.tasly.score.core.api.TCCScoreService;

import org.bytesoft.compensable.Compensable;
import org.bytesoft.compensable.CompensableCancel;
import org.bytesoft.compensable.CompensableConfirm;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by dulei on 18/1/9.
 */
@Slf4j
@Compensable(interfaceClass = TCCScoreService.class,simplified = true)
@RestController
public class TCCScoreServiceImpl implements TCCScoreService {

    @Override
    @Transactional
    public String reduceScore(Integer score) {
        log.info("try reduce Score ");
        return "3";
    }


    @CompensableConfirm
    @Transactional
    public String reduceScoreConfirm(Integer score) {
        log.info("reduceScoreConfirm : [{}]",score);
        return "4";
    }



    @CompensableCancel
    @Transactional
    public String reduceScoreCancle(Integer score) {
        log.info("reduceScoreCancle : [{}]",score);
        return "5";
    }



}
