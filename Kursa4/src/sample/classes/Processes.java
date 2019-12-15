package sample.classes;

import sample.Controller;

import java.util.ArrayList;
import java.util.Comparator;

public class Processes {

    private Scheduler scheduler;

    public ArrayList<Process> getList(){return list;}

    private ArrayList<Process> list;
    private Queue queue;

    public Processes(Scheduler scheduler){
        this.list = new ArrayList<>();
        this.scheduler = scheduler;
    }



    public static Comparator<Process> byPriority  = new Comparator<Process>() {
        @Override
        public int compare(Process o1, Process o2)
        {
            return o1.priority > o2.priority? 1 : o1.priority < o2.priority ? -1 : 0;
        }
    };
    

    public Process CheckPriority(){
        Process runningProcess = null;

        for (Process process:getList()) {
            if(process.getTypeState().equals(StateProcess.RUNNING)){
                runningProcess = process;
            }

           return runningProcess;
        }
        return null;
    }

    public Process processCheck(){
        int minPriority=31;
        Process currentProcess = null;
        for (Process process:getList()) {
            if(process.getPriority()<minPriority&&!process.getTypeState().equals(StateProcess.REJECTED)&&!process.getTypeState().equals(StateProcess.TERMINATED)){
                minPriority=process.getPriority();
                currentProcess = process;
            }
        }
        return currentProcess;
    }


    public void Work() throws InterruptedException {
        Process currentProcess = processCheck();
        queue = new Queue(scheduler);
        if(currentProcess!=null) {
            if (queue.add(currentProcess)) {
                toWork(currentProcess);
                queue.addConfirmedProcess(currentProcess);
            } else {
                getList().get(getList().indexOf(currentProcess)).setTypeState(StateProcess.REJECTED);
                queue.addRejectedProcess(currentProcess);
            }
        }
    }

    private void toWork(Process process) throws InterruptedException {
        getList().get(getList().indexOf(process)).setTypeState(StateProcess.RUNNING);
        SortMemory memoryBlock = new SortMemory(process.getId(), queue.getStart() + 1, queue.getStart() + process.getSize()+1);
        scheduler.add(memoryBlock);
        scheduler.getMemoryBlocks().sort(SortMemory.byAsc);
        Controller.Refresh();
        Thread.sleep(process.getTime()*100);
        process.setTypeState(StateProcess.TERMINATED);
        scheduler.deleteBlock(memoryBlock);
        Controller.Refresh();
    }
}
