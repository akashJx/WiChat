package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MainChatScene implements Initializable  {

    @FXML
    private Label closeLabel;

    @FXML
    private void test(){
        System.out.println("SENDING MSG..!!");
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        closeLabel.setOnMouseClicked(event -> {
            System.out.println("EXITING..");
            System.exit(0);
        });
    }
}
