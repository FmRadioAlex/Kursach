package sample.classes;

import java.util.ArrayList;

public class Scheduler {

    public ArrayList<SortMemory> getMemoryBlocks() {
        return memoryBlocks;
    }

    private ArrayList<SortMemory> memoryBlocks = new ArrayList<>();

    public Scheduler(){
    }

    public void add(SortMemory memoryBlock){
        memoryBlocks.add(memoryBlock);
        memoryBlocks.sort(SortMemory.byAsc);
    }

    public void deleteBlock(SortMemory memoryBlock) {
        getMemoryBlocks().remove(memoryBlock);
    }
}
