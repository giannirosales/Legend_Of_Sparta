module com.example.legend_of_sparta {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.legend_of_sparta to javafx.fxml;
    exports com.example.legend_of_sparta;
}