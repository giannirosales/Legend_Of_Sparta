package com.example.legend_of_sparta;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SpartanApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(SpartanApplication.class.getResource("spartan-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        scene.getRoot().requestFocus(); //updates scene for every frame
        stage.setTitle("Spartan Game");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}