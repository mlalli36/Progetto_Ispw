package com.example.progetto_ispw.user;

import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.signup.exception.UserAlreadyExistsException;
import com.example.progetto_ispw.worker.InfoAppoinEntity;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public UserDAO() {
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


    public void getUserInfo(String email) throws UserNotFoundException {

        try {
            Connection con = getConnector();
            if (con == null)
                throw new SQLException();
            String query = "SELECT Email, Nome, Cognome FROM usersCredenziali WHERE Email = ?;";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setString(1, email);
                ResultSet rs = preparedStatement.executeQuery();
                if (!rs.next()) {
                    throw new UserNotFoundException();
                }
                UserEntity user = UserEntity.getInstance();
                user.setEmail(rs.getString("Email"));
                user.setName(rs.getString("Nome"));
                user.setSurname(rs.getString("Cognome"));
                rs.close();

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public List<InfoAppoinEntity> getAppointmentforUser(String email){
        List<InfoAppoinEntity> appontments =new ArrayList<>();
        try (Connection con = getConnector()) {
            if (con == null)
                throw new SQLException();

            String query = "SELECT * FROM `databaseispw`.`appointment_request` WHERE Client_email = ?  ";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setString(1, email);

                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    InfoAppoinEntity app =  new InfoAppoinEntity();
                    app.setWEmail(rs.getString("Worker_email"));
                    app.setCname(rs.getString("Client_name"));
                    app.setCsurname(rs.getString("Client_surname"));
                    app.setCEmail(rs.getString("Client_email"));
                    app.setDAppo(rs.getString("Date_appointment"));
                    app.setCNumber(rs.getString("Client_number"));
                    app.setDescription(rs.getString("Work_description"));
                    app.setTime(rs.getString("Time_date"));
                    appontments.add(app);
                }
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return appontments;
    }


}