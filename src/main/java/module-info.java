module com.example.spellingbee_1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.spellingbee_1 to javafx.fxml;
    exports com.example.spellingbee_1;
}