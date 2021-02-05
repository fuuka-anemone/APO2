package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.PreventionCare;

public class CoronavirusCareGUI {

    PreventionCare pc = new PreventionCare();

    @FXML
    private ImageView imgViewCare;

    @FXML
    private TextField txtCareNumber;

    @FXML
    private Label txtCareLabel;

    @FXML
    void showCareRecommendation(ActionEvent event) {
        try{
            pc.setCareNumber(Integer.parseInt(txtCareNumber.getText()));
            txtCareLabel.setText(pc.getTextCare());
            imgViewCare.setImage(new Image("resources/"+txtCareNumber.getText()+".png"));
        } catch (Exception e ) {
            txtCareLabel.setText("Invalid input, it must be a numerical value between 1 and 5.");
            imgViewCare.setImage(null);
        }
    }
}