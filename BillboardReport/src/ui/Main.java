package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import model.InfrastructureDepartment;

import java.io.IOException;

public class Main extends Application {

    private InfrastructureDepartment id;
    private BillboardReportGUI brg;

    public Main(){
        id = new InfrastructureDepartment();
        this.brg = new BillboardReportGUI(id);
        try {
            id.loadBillboards();
        } catch (IOException | ClassNotFoundException io){
            brg.showAlert("Data error", Alert.AlertType.ERROR, "There was an unexpected error trying to load the saved data");
        }
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main-pane.fxml"));
        loader.setController(brg);
        primaryStage.setTitle("Dangerous Billboards Report");
        primaryStage.setScene(new Scene(loader.load()));
        primaryStage.show();
    }

    public static void main(String[] args) { launch(args);}
}
