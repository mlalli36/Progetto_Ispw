module com.example.progetto_ispw {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.progetto_ispw to javafx.fxml;
    exports com.example.progetto_ispw;
    exports com.example.progetto_ispw.login;
    opens com.example.progetto_ispw.login to javafx.fxml;
    exports com.example.progetto_ispw.login.Exception;
    opens com.example.progetto_ispw.login.Exception to javafx.fxml;
}