package sample.classes;

import java.util.Date;
import java.util.Timer;

public class ClassRealizationTask {

    public  ClassRealizationTask(){

    }

    public void Generate(Processes processes) //создание процесса в программе
    {
        Timer timer = new Timer("Generate process");
        TimerTaskProcess timerTaskProcess = new TimerTaskProcess(processes);
        //ProcessWork processWork = new ProcessWork(processes);
        Date date = new Date();
        long delay = 5 * 1000;
        timer.scheduleAtFixedRate(timerTaskProcess, date, delay);
    }
}
