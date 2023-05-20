package com.example.progetto_ispw.login;

import com.example.progetto_ispw.User.UserEntity;
import com.example.progetto_ispw.login.exception.LoginFailedException;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.salt.ZeroSaltGenerator;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class LoginController {

    private static final String ENCRYPTION_KEY ="ISPW_PROJECT_WORKERLINK_2023";

    private static final String DB_URL = "jdbc:mysql://localhost:3306/databaseispw";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "0000";

    public void loginUser(LoginBean bean) throws UserNotFoundException, LoginFailedException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Configura la connessione al database locale
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/databaseispw", "root", "0000");

            // Esegui la query per ottenere l'utente dal database
            String query = "SELECT * FROM users WHERE email = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, bean.getEmail());
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                UserEntity user = UserEntity.getInstance();  //UserEntity.getInstance() : utente trovato nel database

                String decryptedPassword = this.decryptPassword(resultSet.getString("password")); //pass nel db trovata e decriptata

                if (!Objects.equals(decryptedPassword, bean.getPassword())) {
                    throw new LoginFailedException("The password is incorrect");
                }
            } else {
                throw new UserNotFoundException("User not found");
            }
        } catch (SQLException e) {
            // Gestisci eventuali errori di connessione o query
            e.printStackTrace();
        } finally {
            // Chiudi le risorse
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private String decryptPassword(String psw) { //Viene passata la stringa criptata della password e non l'istanza
        //dell'user così il metodo non deve conoscere come è realizzata la
        //classe user
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(ENCRYPTION_KEY); //chiave per criptare la psw
        encryptor.setSaltGenerator(new ZeroSaltGenerator()); //Non utilizzare salt per l'encryption, così da avere
        //risultati uguali ogni volta che si cripta e decripta la
        //la stessa parola

        return encryptor.decrypt(psw);
    }
}
