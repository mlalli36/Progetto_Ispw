module com.example.progetto_ispw {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jasypt;


    opens com.example.progetto_ispw to javafx.fxml;
    exports com.example.progetto_ispw;
    exports com.example.progetto_ispw.login;
    opens com.example.progetto_ispw.login to javafx.fxml;
    exports com.example.progetto_ispw.login.exception;
    opens com.example.progetto_ispw.login.exception to javafx.fxml;
    exports com.example.progetto_ispw.user;
    opens com.example.progetto_ispw.user to javafx.fxml;
    exports com.example.progetto_ispw.signup;
    opens com.example.progetto_ispw.signup to javafx.fxml;
}