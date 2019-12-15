package sample.classes;

import java.util.ArrayList;
import java.util.Random;

/**
 * созданн класс ENUM: в котором программа выбирает названия классов
 */

public class NamesOfProcess
{
    private ArrayList<String> processNames = new ArrayList<>();
    private Random random = new Random();

    public NamesOfProcess(){
        processNames.add("Копирование");
        processNames.add("Открытие");
        processNames.add("Включение");
        processNames.add("Запись");
        processNames.add("Отправление");
    }

    public String getRandomProcessName(){
        int index = random.nextInt(processNames.size()-1);
        return this.processNames.get(index);
    }
}
