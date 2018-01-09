package com.tasly.user.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

/**
 * Created by dulei on 18/1/9.
 *
 *
 */
@Component
public class MyHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {

        return new Health.Builder(Status.DOWN).build();
    }
}
