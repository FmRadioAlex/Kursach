package sample.classes;

import java.util.Random;

public class Process {
    private String name;
    private int id=0;
    private int timeOfTacts;
    private int timeIn;
    private int time;
    public int priority;
    private int size;

    private Random random = new Random();
    private final int maxInt = 300;
    private final int minInt = 10;
    private StateProcess typeState;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTimeOfTacts() {
        return timeOfTacts;
    }

    public void setTimeOfTacts(int timeOfTacts) {
        this.timeOfTacts = timeOfTacts;
    }

    public int getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(int timeIn) {
        this.timeIn = timeIn;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public StateProcess getTypeState() {
        return typeState;
    }

    public void setTypeState(StateProcess typeState) {
        this.typeState = typeState;
    }

    public Process(){

    }

    public Process(String name, int id){
        this.id = id;
        this.name = name;
        this.timeOfTacts = random.nextInt(maxInt-minInt)+minInt;
        this.timeIn = random.nextInt(maxInt-minInt)+minInt;
        this.time = random.nextInt(maxInt-minInt)+minInt;
        this.typeState = StateProcess.NEW;
        this.priority = random.nextInt(Utils.maxPriority - Utils.minPriority)+Utils.minPriority;
        this.size = random.nextInt(Utils.maxMemorySize/2);
    }

}
