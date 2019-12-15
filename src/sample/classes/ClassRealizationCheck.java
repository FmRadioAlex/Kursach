package sample.classes;

import java.util.Date;
import java.util.Timer;

public class ClassRealizationCheck {
    public ClassRealizationCheck(){

    }

    public void Check(Processes processes)
    {
        Timer timer = new Timer("Check process");
        TimerTaskCheck timerTaskCheck = new TimerTaskCheck(processes);
        Date date = new Date();
        long delay = 1 * 1000;
        timer.scheduleAtFixedRate(timerTaskCheck, date, delay);
    }

}
