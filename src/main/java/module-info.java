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
    exports com.example.progetto_ispw.User;
    opens com.example.progetto_ispw.User to javafx.fxml;
    exports com.example.progetto_ispw.SignUp;
    opens com.example.progetto_ispw.SignUp to javafx.fxml;
}