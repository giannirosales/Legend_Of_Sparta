package com.example.legend_of_sparta;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SpartanController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}