package com.example.progetto_ispw.worker;

import com.example.progetto_ispw.signup.exception.UserAlreadyExistsException;
import com.example.progetto_ispw.user.UserEntity;

import java.sql.*;

import static com.example.progetto_ispw.utile.DBConnector.getConnector;

public class WorkerDAO {

    private static WorkerDAO instance = null;

    public static WorkerDAO getInstance() {
        if (WorkerDAO.instance == null)
            return new WorkerDAO();
        else {
            WorkerDAO.instance = new WorkerDAO();
            return WorkerDAO.instance;
        }
    }

    private WorkerDAO() {
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
               WorkerEntity worker = WorkerEntity.getInstance();
                worker.setEmail(email);
                worker.setDescription(description);
                worker.setWork(work);
                worker.setName(nome);
                worker.setSurname(cognome);
                worker.setAddress(indirizzo);
                worker.setLocation(location);

            }

        } catch (SQLIntegrityConstraintViolationException e) {
            throw new UserAlreadyExistsException();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public WorkerEntity getWorker(String nameWorker, String jobWorker, String locationWorker)  {
        WorkerEntity worker = null;
        try {
            Connection con = getConnector();
            if (con == null)
                throw new SQLException();
            String query = "SELECT * FROM `tabella informazioni` WHERE Name = ? AND Work = ? AND Location = ?;";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setString(1, nameWorker);
                preparedStatement.setString(2, jobWorker);
                preparedStatement.setString(3, locationWorker);
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    //capire se bisogna cambiare UserEntity
                    worker = WorkerEntity.getInstance();
                    worker.setEmail(rs.getString("Email"));
                    worker.setDescription(rs.getString("Description"));
                    worker.setWork(rs.getString("Work"));
                    worker.setName(rs.getString("Name"));
                    worker.setSurname(rs.getString("Surname"));
                    worker.setAddress(rs.getString("Address"));
                    worker.setLocation(rs.getString("Location"));
                }
                rs.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return worker;
    }
}
