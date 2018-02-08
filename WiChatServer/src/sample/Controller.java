package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    public Parent root;
    public Stage window = new Stage();


    public Stage stage;
    @FXML
    private Label closeLabel;

    @FXML
    private Button loginBtn;

    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    private void loginNow()throws IOException {
        // Stage window = new Stage();
        // Parent root;

        System.out.println("Scene changing...");
        // root = FXMLLoader.load(getClass().getResource("MainChatScene.fxml"));
        window.initStyle(StageStyle.UNDECORATED);
        window.setScene(new Scene(root));
        window.show();

        //--@Click and Drag-----------------------------------------------------
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                window.setX(event.getScreenX() - xOffset);
                window.setY(event.getScreenY() - yOffset);
            }
        });
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        closeLabel.setOnMouseClicked(event -> {
            System.out.println("EXITING..");
            System.exit(0);
        });
    }

}


