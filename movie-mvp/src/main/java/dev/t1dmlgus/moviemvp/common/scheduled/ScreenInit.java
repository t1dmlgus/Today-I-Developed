package dev.t1dmlgus.moviemvp.common.scheduled;


import org.springframework.scheduling.annotation.Scheduled;


public class ScreenInit {


    @Scheduled(cron = "* * * * * 15")
    public void ScreenScheduledInit(){
        System.out.println(" hi ");
    }
}