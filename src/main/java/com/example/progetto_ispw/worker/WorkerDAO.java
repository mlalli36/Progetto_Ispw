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
    public WorkerEntity getWorker(String nameWork, String jobWork, String locationWork)  {
        try {
            Connection con = getConnector();
            if (con == null)
                throw new SQLException();
            String query = "SELECT Email, Description, Work, Name, Surname, Address, Location FROM tabella informazioni WHERE Name Work Location = ?,?,?;";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setString(1, nameWork);
                preparedStatement.setString(2, jobWork);
                preparedStatement.setString(3, locationWork);
                ResultSet rs = preparedStatement.executeQuery();
                if (!rs.next()) {
                    throw new NullPointerException("Worker Not Found");
                }
                //capire se bisogna cambiare UserEntity
                UserEntity user = UserEntity.getInstance();
                user.setEmail(rs.getString("Email"));
                user.setDescription(rs.getString("Description"));
                user.setWork(rs.getString("Work"));
                user.setName(rs.getString("Name"));
                user.setSurname(rs.getString("Surname"));
                user.setAddress(rs.getString("Address"));
                user.setLocation(rs.getString("Location"));
                rs.close();

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
