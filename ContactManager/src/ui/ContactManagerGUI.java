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
import model.Contact;
import model.ContactManager;

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

    public ContactManagerGUI() {
        contactM = new ContactManager();
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
            //System.out.println("the items in the ContactManagerArraylist are: " + contactM.getContacts());
            ObservableList<Contact> data = FXCollections.observableArrayList(contactM.getContacts());
            //System.out.println("the items in the OBSERVABLELIST are: " + data);
            contactsTV.setItems(data);
            //System.out.println("the items in the tableview are: " + contactsTV.getItems());
            numCol.setCellValueFactory(new PropertyValueFactory<>("num"));
            nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
