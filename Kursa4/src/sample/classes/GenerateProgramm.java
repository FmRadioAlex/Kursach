package sample.classes;

import sample.Controller;

public class GenerateProgramm  //создание программы
{
    private int id=0;

    public void generate(Processes processes) {
        NamesOfProcess processNames = new NamesOfProcess();
        processes.getList().add(new Process(processNames.getRandomProcessName(), ++id));
        processes.getList().sort(processes.byPriority);
        Controller.Refresh();
    }
}
