package com.tasly.user.health;

import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

/**
 * Created by dulei on 18/1/9.
 */
@Component
public class MyHealthCheckHandler implements HealthCheckHandler {

    @Autowired
    private MyHealthIndicator myHealthIndicator;

    @Override
    public InstanceInfo.InstanceStatus getStatus(InstanceInfo.InstanceStatus instanceStatus) {
        Status status = myHealthIndicator.health().getStatus();
        if(Status.UP.equals(status)){
            return InstanceInfo.InstanceStatus.UP;
        }

        return InstanceInfo.InstanceStatus.DOWN;

    }
}
