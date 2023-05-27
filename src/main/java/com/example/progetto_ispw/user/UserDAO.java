package com.example.progetto_ispw.user;

import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.signup.exception.UserAlreadyExistsException;

import java.sql.*;

import static com.example.progetto_ispw.utile.DBConnector.getConnector;

public class UserDAO {

    private static UserDAO instance = null;

    public static UserDAO getInstance() {
        if (UserDAO.instance == null)
            return new UserDAO();
        else {
            UserDAO.instance = new UserDAO();
            return UserDAO.instance;
        }
    }

    private UserDAO() {
    }

    public void getUser(String email) throws UserNotFoundException {

        try {
            Connection con = getConnector();
            if (con == null)
                throw new SQLException();
            String query = "SELECT Email, Password, Tipoaccesso FROM usersCredenziali WHERE Email = ?;";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setString(1, email);
                ResultSet rs = preparedStatement.executeQuery();
                if (!rs.next()) {
                    throw new UserNotFoundException();
                }
                UserEntity user = UserEntity.getInstance();
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("Password"));
                user.setTipoaccesso(rs.getString("Tipoaccesso"));
                rs.close();

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




   public void addUser(String name, String surname, String email, String password,String tipoaccesso) throws UserAlreadyExistsException {
        try (Connection con = getConnector()) {
            if (con == null)
                throw new SQLException();
            String query = "INSERT INTO `databaseispw`.`usersCredenziali` (`Nome`,`Cognome`,`Email`, `Password`,`Tipoaccesso`) VALUES (?, ?, ?, ?, ?);";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, surname);
                preparedStatement.setString(3, email);
                preparedStatement.setString(4, password);
                preparedStatement.setString(5, tipoaccesso);

                preparedStatement.executeUpdate();
                UserEntity user = UserEntity.getInstance();
                user.setEmail(email);
                user.setPassword(password);
                user.setTipoaccesso(tipoaccesso);

            }

        } catch (SQLIntegrityConstraintViolationException e) {
            throw new UserAlreadyExistsException();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}