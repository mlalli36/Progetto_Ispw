module com.example.progetto_ispw {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jasypt;
    requires java.desktop;


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
    exports com.example.progetto_ispw.signup.exception;
    opens com.example.progetto_ispw.signup.exception to javafx.fxml;
    exports com.example.progetto_ispw.profilesignup;
    opens com.example.progetto_ispw.profilesignup to javafx.fxml;
    exports com.example.progetto_ispw.home;
    opens com.example.progetto_ispw.home to javafx.fxml;
    exports com.example.progetto_ispw.searchdinamica;
    opens com.example.progetto_ispw.searchdinamica to javafx.fxml;
    exports com.example.progetto_ispw.savehoursslots;
    opens com.example.progetto_ispw.savehoursslots to javafx.fxml;
    exports com.example.progetto_ispw.savehoursslots.exception;
    opens com.example.progetto_ispw.savehoursslots.exception to javafx.fxml;
    exports com.example.progetto_ispw.userprofile;
    opens com.example.progetto_ispw.userprofile to javafx.fxml;
    exports com.example.progetto_ispw.workerprofile;
    opens com.example.progetto_ispw.workerprofile to javafx.fxml;
    exports com.example.progetto_ispw.fillform;
    opens com.example.progetto_ispw.fillform to javafx.fxml;
    exports com.example.progetto_ispw.notificadacliente;
    opens com.example.progetto_ispw.notificadacliente to javafx.fxml;
    exports com.example.progetto_ispw.notifications;
    opens com.example.progetto_ispw.notifications to javafx.fxml;
}