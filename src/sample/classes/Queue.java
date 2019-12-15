package sample.classes;

import java.util.ArrayList;

public class Queue {
    private ConfirmedQueue confirmedQueue = new ConfirmedQueue();
    private RejectedQueue rejectedQueue = new RejectedQueue();
    private Scheduler scheduler;
    private int start;

    public int getStart() {return start;}

    public Queue (){

    }

    public Queue(Scheduler scheduler){
        this.scheduler=scheduler;
    }

    public ArrayList getConfirmedProcesses(){
        return confirmedQueue.getConfirmedQueue();
    }

    public void addConfirmedProcess(Process process){
        confirmedQueue.add(process);
    }

    public void addRejectedProcess(Process process){
        rejectedQueue.add(process);
    }

    public ArrayList getRejectedProcesses(){
        return rejectedQueue.getRejectedQueue();
    }

    boolean add(Process process){
        ArrayList<Integer> listResults = new ArrayList<>();
        int min=0;
        for(int i=0; i<scheduler.getMemoryBlocks().size()-1;i++){
            if(SortMemory.byEnd.compare(scheduler.getMemoryBlocks().get(i), scheduler.getMemoryBlocks().get(i+1))>=process.getSize()){
                listResults.add(SortMemory.byEnd.compare(scheduler.getMemoryBlocks().get(i), scheduler.getMemoryBlocks().get(i+1)));
                min = SortMemory.byEnd.compare(scheduler.getMemoryBlocks().get(i), scheduler.getMemoryBlocks().get(i+1));
            }
        }

        for (int i:listResults) {
            if(i<min){
                min=i;
            }
        }

        boolean isConfirmed = false;
        for (int i=0; i<scheduler.getMemoryBlocks().size()-1;i++) {
            if(SortMemory.byEnd.compare(scheduler.getMemoryBlocks().get(i), scheduler.getMemoryBlocks().get(i+1))==min){
                this.start = scheduler.getMemoryBlocks().get(i).getEnd();
                process.setTypeState(StateProcess.READY);
                confirmedQueue.add(process);
                isConfirmed=true;
                break;
            }
        }
        if(!isConfirmed) {
            process.setTypeState(StateProcess.REJECTED);
            rejectedQueue.add(process);
        }
        return isConfirmed;
    }
}
