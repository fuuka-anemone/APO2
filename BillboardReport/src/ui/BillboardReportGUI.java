package ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Billboard;
import model.InfrastructureDepartment;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class BillboardReportGUI {

    @FXML
    private TableView<Billboard> billboardsTV;

    @FXML
    private TableColumn<Billboard, Double> widthTC;

    @FXML
    private TableColumn<Billboard, Double> heightTC;

    @FXML
    private TableColumn<Billboard, Boolean> useTC;

    @FXML
    private TableColumn<Billboard, String> brandTC;


    private InfrastructureDepartment ifd;

    @FXML
    private TextField widthTxtFd;

    @FXML
    private TextField heightTxtFd;

    @FXML
    private TextField brandTxtFd;

    @FXML
    private ComboBox<String> useComBox;

    @FXML
    private BorderPane mainBorderPane;

    @FXML
    private ImageView billboardIV;

    @FXML
    private ImageView mainBorderPaneIV;

    private static Alert alert;

    private static FileChooser fileChooser;

    public BillboardReportGUI(InfrastructureDepartment ifd) {
        alert = new Alert(null);
        this.ifd = ifd;
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Plain text files", "*.txt", "*.csv"),
                new FileChooser.ExtensionFilter("TXT", "*.txt"),
                new FileChooser.ExtensionFilter("CSV", "*.csv"));
    }

    @FXML
    public void initialize(){
        mainBorderPaneIV.setImage(new Image("file:resources/intro.png"));
    }
    //add item on main-pane menu
    @FXML
    public void addBillboard(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("add-billboard.fxml"));
        loader.setController(this);
        mainBorderPane.setCenter(loader.load());
        mainBorderPane.setBottom(null);
        initializeComboBox();
        billboardIV.setImage(new Image("file:resources/billboard.png"));
    }

    @FXML
    public void exportMenu(ActionEvent event) throws IOException {
        File file = fileChooser.showSaveDialog(mainBorderPane.getScene().getWindow());
        fileChooser.setTitle("Select the directory or file where the data will be saved");
        if (file != null) {
            try {
                ifd.exportDangerousBillboardReport(file.toString());
                showAlert("Success", Alert.AlertType.INFORMATION, "The data has been exported successfully");
            } catch (IOException io){
                showAlert("Data Error", Alert.AlertType.ERROR, "There was an unexpected error trying to export the data into the specified file");
            }
        }
    }

    @FXML
    public void importMenu(ActionEvent event) throws IOException {
        File file = fileChooser.showOpenDialog(mainBorderPane.getScene().getWindow());
        fileChooser.setTitle("Select the file that you want to import");
        if (file != null) {
            try {
                ifd.importData(file.toString());
                showAlert("Success", Alert.AlertType.INFORMATION, "The data has been imported successfully");
                if (mainBorderPane.getCenter().getClass().equals(javafx.scene.layout.HBox.class)) {
                    setTableView();
                }
            } catch (IOException io){
                showAlert("Data Error", Alert.AlertType.ERROR, "There was an unexpected error trying to import the data from the specified file");
            }
        }
    }

    @FXML
    public void listBillboards(ActionEvent event)  throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("list-billboards.fxml"));
        loader.setController(this);
        mainBorderPane.setCenter(loader.load());
        mainBorderPane.setBottom(null);
        setTableView();
    }

    //add button on add-billboard.fxml
    @FXML
    public void addNewBillboard(ActionEvent event) {
        try{
            ifd.addBillboard(Double.parseDouble(widthTxtFd.getText()),
                    Double.parseDouble(heightTxtFd.getText()),
                    useComBox.getValue().equals("Yes"),
                    Objects.requireNonNull(brandTxtFd.getText()));
            showAlert("Success", Alert.AlertType.INFORMATION, "The new billboard was added successfully");
        } catch (NullPointerException | IllegalArgumentException ni){
            showAlert("Input Error", Alert.AlertType.WARNING, "Be sure to fill all the fields correctly");
        } catch (IOException io){
            showAlert("Data Error", Alert.AlertType.ERROR, "There was an unexpected problem trying to add the new billboard");
        }
    }

    public void initializeComboBox() {
        ObservableList<String> bool = FXCollections.observableArrayList("Yes", "No");
        useComBox.setItems(bool);
    }

    private void setTableView() {
        try {
            Stage s = (Stage)(mainBorderPane.getScene().getWindow());
            billboardsTV.prefWidthProperty().bind(s.widthProperty());
            billboardsTV.prefHeightProperty().bind(s.heightProperty());
            ObservableList<Billboard> data = FXCollections.observableArrayList();
            for (Billboard b : ifd.getBillboards()){
                if (b.calculateArea() >= 160.0){
                    data.add(b);
                }
            }
            billboardsTV.setItems(data);
            widthTC.setCellValueFactory(new PropertyValueFactory<>("width"));
            heightTC.setCellValueFactory(new PropertyValueFactory<>("height"));
            useTC.setCellValueFactory(new PropertyValueFactory<>("inUse"));
            brandTC.setCellValueFactory(new PropertyValueFactory<>("brand"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void showAlert(String title, Alert.AlertType type, String content){
        alert.setAlertType(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
