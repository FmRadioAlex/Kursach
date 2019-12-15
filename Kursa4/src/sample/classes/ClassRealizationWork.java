package sample.classes;

import java.util.Date;
import java.util.Timer;

public class ClassRealizationWork {

    public ClassRealizationWork(){}

    public void Work(Processes processes) //работа процессора
    {
        Timer timer = new Timer("Work");
        TimerTaskWork timerTaskWork = new TimerTaskWork(processes);
        Date date = new Date();
        long delay = 1 * 1000;
        timer.scheduleAtFixedRate(timerTaskWork, date, delay);
    }

}
