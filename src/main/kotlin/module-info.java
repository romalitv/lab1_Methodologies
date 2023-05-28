module com.example.task {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens com.example.task1 to javafx.fxml;
    exports com.example.task1;
}