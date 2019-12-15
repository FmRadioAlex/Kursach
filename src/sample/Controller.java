package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.classes.*;
import sample.classes.Process;

public class Controller {

    private static ObservableList<Process> list = FXCollections.observableArrayList();
    private static ObservableList<Process> listConfirmed = FXCollections.observableArrayList();
    private static ObservableList<Process> listRejected = FXCollections.observableArrayList();
    private static ObservableList<SortMemory> listMemory = FXCollections.observableArrayList();


    @FXML
    private TableView<Process> tableProcesses;

    @FXML
    private TableColumn<Process, Integer> idColumn;

    @FXML
    private TableColumn<Process, String> nameColumn;

    @FXML
    private TableColumn<Process, Integer> timeOfTactsColumn;

    @FXML
    private TableColumn<Process, Integer> timeInColumn;

    @FXML
    private TableColumn<Process, Integer> timeColumn;

    @FXML
    private TableColumn<Process, String> stateColumn;

    @FXML
    private TableColumn<Process, Integer> priorityColumn;

    @FXML
    private TableColumn<Process, Integer> sizeColumn;

    @FXML
    private TableView<Process> tableConfirmedProcesses;

    @FXML
    private TableColumn<Process, Integer> idConfirmedColumn;

    @FXML
    private TableColumn<Process, String> nameConfirmedColumn;

    @FXML
    private TableColumn<Process, Integer> timeOfTactsConfirmedColumn;

    @FXML
    private TableColumn<Process, Integer> timeInConfirmedColumn;

    @FXML
    private TableColumn<Process, String> stateConfirmedColumn;

    @FXML
    private TableColumn<Process, Integer> priorityConfirmedColumn;

    @FXML
    private TableColumn<Process, Integer> sizeConfirmedColumn;

    @FXML
    private TableView<Process> tableRejectedProcesses;

    @FXML
    private TableColumn<Process, Integer> idRejectedColumn;

    @FXML
    private TableColumn<Process, String> nameRejectedColumn;

    @FXML
    private TableColumn<Process, String> stateRejectedColumn;

    @FXML
    private TableColumn<Process, Integer> sizeRejectedColumn;

    @FXML
    private TableView<SortMemory> tableMemoryBlocks;

    @FXML
    private TableColumn<SortMemory, Integer> startMemoryBlockColumn;

    @FXML
    private TableColumn<SortMemory, Integer> endMemoryBlockColumn;

    private static Queue queue = new Queue();
    private static Scheduler scheduler = new Scheduler();
    private static Processes processes = new Processes(scheduler);

    public void initialize() //инициализируем все колонки из визуализации
    {
        idConfirmedColumn.setCellValueFactory(new PropertyValueFactory<Process, Integer>("id"));
        nameConfirmedColumn.setCellValueFactory(new PropertyValueFactory<Process, String>("name"));
        timeOfTactsConfirmedColumn.setCellValueFactory(new PropertyValueFactory<Process, Integer>("timeOfTacts"));
        timeInConfirmedColumn.setCellValueFactory(new PropertyValueFactory<Process, Integer>("timeIn"));
        stateConfirmedColumn.setCellValueFactory(new PropertyValueFactory<Process, String>("typeState"));
        priorityConfirmedColumn.setCellValueFactory(new PropertyValueFactory<Process, Integer>("priority"));
        sizeConfirmedColumn.setCellValueFactory(new PropertyValueFactory<Process, Integer>("size"));

        idRejectedColumn.setCellValueFactory(new PropertyValueFactory<Process, Integer>("id"));
        nameRejectedColumn.setCellValueFactory(new PropertyValueFactory<Process, String>("name"));
        stateRejectedColumn.setCellValueFactory(new PropertyValueFactory<Process, String>("typeState"));
        sizeRejectedColumn.setCellValueFactory(new PropertyValueFactory<Process, Integer>("size"));

        idColumn.setCellValueFactory(new PropertyValueFactory<Process, Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Process, String>("name"));
        timeOfTactsColumn.setCellValueFactory(new PropertyValueFactory<Process, Integer>("timeOfTacts"));
        timeInColumn.setCellValueFactory(new PropertyValueFactory<Process, Integer>("timeIn"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<Process, Integer>("time"));
        stateColumn.setCellValueFactory(new PropertyValueFactory<Process, String>("typeState"));
        priorityColumn.setCellValueFactory(new PropertyValueFactory<Process, Integer>("priority"));
        sizeColumn.setCellValueFactory(new PropertyValueFactory<Process, Integer>("size"));

        startMemoryBlockColumn.setCellValueFactory(new PropertyValueFactory<SortMemory, Integer>("start"));
        endMemoryBlockColumn.setCellValueFactory(new PropertyValueFactory<SortMemory, Integer>("end"));




        scheduler.add(new SortMemory(0,0,127));
        scheduler.add(new SortMemory(0,727,850));
        scheduler.add(new SortMemory(0,1130,1610));
        scheduler.add(new SortMemory(0, Utils.maxMemorySize-148, Utils.maxMemorySize));

        listMemory.addAll(scheduler.getMemoryBlocks());
        list.addAll(processes.getList());


        tableProcesses.setItems(list);
        tableConfirmedProcesses.setItems(listConfirmed);
        tableRejectedProcesses.setItems(listRejected);
        tableMemoryBlocks.setItems(listMemory);

        ClassRealizationTask classExecutingTask = new ClassRealizationTask();
        classExecutingTask.Generate(processes);

        ClassRealizationWork classExecutingWork = new ClassRealizationWork();
        classExecutingWork.Work(processes);

        ClassRealizationCheck classExecutingCheck = new ClassRealizationCheck();
        classExecutingCheck.Check(processes);
    }

    public static void Refresh(){
        list.clear();
        list.addAll(processes.getList());
        listMemory.clear();
        listMemory.addAll(scheduler.getMemoryBlocks());
        listConfirmed.clear();
        for (Process process:processes.getList()) {
            if(process.getTypeState().equals(StateProcess.READY)||process.getTypeState().equals(StateProcess.RUNNING)||process.getTypeState().equals(StateProcess.TERMINATED)){
                listConfirmed.add(process);
            }
        }
        listRejected.clear();
        for (Process process:processes.getList()) {
            if(process.getTypeState().equals(StateProcess.REJECTED)){
                listRejected.add(process);
            }
        }
    }
}
