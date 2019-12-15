package sample.classes;

import java.util.Comparator;

public class SortMemory {
    private int id;
    private int start;
    private int end;
    public static final int maxPriority = 32;
    public static final int minPriority = 1;

    public int getId() {
        return id;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public static Comparator<SortMemory> byEnd = new Comparator<SortMemory>() {
        @Override
        public int compare(SortMemory o1, SortMemory o2) {
            return o2.start - o1.end;
        }
    };

    public static Comparator<SortMemory> byAsc = new Comparator<SortMemory>() {
        @Override
        public int compare(SortMemory o1, SortMemory o2) {
            return o1.start > o2.start ? 1 : o1.start < o2.start ? -1 : 0;
        }
    };



    public SortMemory(){
    }

    public SortMemory(int id , int start, int end) {
        this.id = id;
        this.start = start;
        this.end = end;
    }
}
