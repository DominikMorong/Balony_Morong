module com.example.balony_morong {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.balony_morong to javafx.fxml;
    exports com.example.balony_morong;
}