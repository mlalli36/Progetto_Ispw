module com.example.progetto_ispw {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.progetto_ispw to javafx.fxml;
    exports com.example.progetto_ispw;
}