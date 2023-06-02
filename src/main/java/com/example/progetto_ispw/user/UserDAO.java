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

    public void addWorker (String email, String description, String work,String nome , String cognome, String indirizzo, String location ) throws UserAlreadyExistsException {
        try (Connection con = getConnector()) {
            if (con == null)
                throw new SQLException();
            String query = "INSERT INTO `databaseispw`.`tabella informazioni` (`Email`,`Description`,`Work`, `Name`,`Surname`,`Address`,`Location`) VALUES (?, ?, ?, ?, ?, ?, ?);";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, description);
                preparedStatement.setString(3, work);
                preparedStatement.setString(4, nome);
                preparedStatement.setString(5, cognome);
                preparedStatement.setString(6, indirizzo);
                preparedStatement.setString(7, location);

                preparedStatement.executeUpdate();
                UserEntity user = UserEntity.getInstance();
                user.setEmail(email);
                user.setDescription(description);
                user.setWork(work);
                user.setName(nome);
                user.setSurname(cognome);
                user.setAddress(indirizzo);
                user.setLocation(location);

            }

        } catch (SQLIntegrityConstraintViolationException e) {
            throw new UserAlreadyExistsException();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

// continuare di qui, bisogna aggiungere anche il campo località in scene builder in profile sign up
    // poi bisogna collegare il db a quello e salvare i dati









}