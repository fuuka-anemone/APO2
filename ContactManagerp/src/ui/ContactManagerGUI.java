package ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Contact;
import model.ContactManager;

import java.io.File;
import java.io.IOException;

public class ContactManagerGUI {

    @FXML
    private BorderPane mainPane;

    @FXML
    private TextField txtfdName;

    @FXML
    private TextField txtfdEmail;

    @FXML
    private TableView<Contact> contactsTV;

    @FXML
    private TableColumn<Contact, Integer> numCol;

    @FXML
    private TableColumn<Contact, String> nameCol;

    @FXML
    private TableColumn<Contact, String> emailCol;

    private ContactManager contactM;

    private final FileChooser fileChooser;

    private final Alert alert;

    public ContactManagerGUI() {
        fileChooser = new FileChooser();
        contactM = new ContactManager();
        alert = new Alert(null);
    }

    @FXML
    void addContact(ActionEvent event) {
        contactM.addContact(txtfdName.getText(), txtfdEmail.getText());
        //System.out.println("the items in the ContactManagerArraylist are: " + contactM.getContacts());
        txtfdName.clear();
        txtfdEmail.clear();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Contact Manager");
        alert.setHeaderText(null);
        alert.setContentText("Contact added successfully");
        alert.showAndWait();
    }

    @FXML
    void setAddWindow(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddWindow.fxml"));
        loader.setController(this);
        mainPane.setCenter(loader.load());
        //System.out.println("the items in the ContactManagerArraylist are: " + contactM.getContacts());
    }

    @FXML
    void setListWindow(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ListWindow.fxml"));
        loader.setController(this);
        mainPane.setCenter(loader.load());
        setTableView();
    }

    private void setTableView() {
        try {
            Stage s = (Stage)(mainPane.getScene().getWindow());
            contactsTV.prefWidthProperty().bind(s.widthProperty());
            contactsTV.prefHeightProperty().bind(s.heightProperty());
            ObservableList<Contact> data = FXCollections.observableArrayList(contactM.getContacts());
            contactsTV.setItems(data);
            numCol.setCellValueFactory(new PropertyValueFactory<>("num"));
            nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    @FXML
    public void exportContacts(ActionEvent event) throws IOException {
        File file = fileChooser.showOpenDialog(mainPane.getScene().getWindow());
        fileChooser.setTitle("Export to: ");
        try {
            if (file != null) {
                contactM.exportContacts(file.getAbsolutePath());
                showAlert(Alert.AlertType.INFORMATION,"Contacts exported successfully", null);
            }
        } catch (IOException io){
            showAlert(Alert.AlertType.ERROR,"There was an error while trying to export the contacts", null);
        }
    }

    @FXML
    public void importContacts(ActionEvent event) throws IOException{
        File file = fileChooser.showOpenDialog(mainPane.getScene().getWindow());
        fileChooser.setTitle("Import from: ");
        try {
            if (file != null) {
                contactM.importContacts(file.getAbsolutePath());
                showAlert(Alert.AlertType.INFORMATION,"Contacts imported successfully", null);
                setListWindow(null);
            }
        } catch (IOException io){
            showAlert(Alert.AlertType.ERROR,"There was an error while trying to import the contacts", null);
        }
    }

    public void showAlert(Alert.AlertType type, String content, String header){
        alert.setAlertType(type);
        alert.setContentText(content);
        alert.setHeaderText(header);
        alert.showAndWait();
    }
}
