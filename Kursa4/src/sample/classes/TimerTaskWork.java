package sample.classes;

import sample.Controller;

import java.util.TimerTask;

public class TimerTaskWork extends TimerTask {

    private Processes processes;

    public TimerTaskWork(Processes processes){
        this.processes = processes;
    }

    @Override
    public void run() {
        try {
            processes.Work();
            Controller.Refresh();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
