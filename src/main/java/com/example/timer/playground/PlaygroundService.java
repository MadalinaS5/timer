package com.example.timer.playground;

import com.example.timer.info.TimerInfo;
import com.example.timer.jobs.HelloWorldJob;
import com.example.timer.timerService.SchedulerService;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaygroundService {
    private final SchedulerService scheduler;

    @Autowired
    public PlaygroundService(final SchedulerService schedule) {
        this.scheduler = schedule;
    }

    public void runHelloWorldJob() {
        final TimerInfo info=new TimerInfo();
        info.setTotalFireCount(3);
        info.setRepeatIntervalMs(30000);
        info.setInitialOffsetMs(1000);
        info.setCallbackData("My callback data");

        scheduler.schedule(HelloWorldJob.class, info);
    }
}
