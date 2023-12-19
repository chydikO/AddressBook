package com.chudik0.addressbook;

import com.chudik0.addressbook.controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 275);
        MainController mainController = fxmlLoader.getController();
        mainController.setMainStage(stage);

        stage.setMinHeight(600);
        stage.setWidth(500);
        stage.setTitle("Address Book");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}