package com.example.progetto_ispw.worker;

import com.example.progetto_ispw.saveHoursSlots.SlotHoursEntity;
import com.example.progetto_ispw.saveHoursSlots.exception.TimeSlotAlreadyExistsException;
import com.example.progetto_ispw.signup.exception.UserAlreadyExistsException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public void addWorker(String email, String description, String work, String nome, String cognome, String indirizzo, String location) throws UserAlreadyExistsException {
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
                WorkerEntity worker = new WorkerEntity();
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


    //forse questa deve rutornare una List<WorkEntuty> e WorkEntity potrebbe non dover essere Singleton

    public List<WorkerEntity> getWorker(String jobWorker, String locationWorker) {
        List<WorkerEntity> workerList = new ArrayList<>();

        try {
            Connection con = getConnector();
            if (con == null)
                throw new SQLException();
            String query = "SELECT * FROM `tabella informazioni` WHERE Work = ? AND Location = ?;";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                //preparedStatement.setString(1, nameWorker);
                preparedStatement.setString(1, jobWorker);
                preparedStatement.setString(2, locationWorker);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {

                    WorkerEntity workerEntity = new WorkerEntity();
                    workerEntity.setEmail(rs.getString("Email"));
                    workerEntity.setDescription(rs.getString("Description"));
                    workerEntity.setWork(rs.getString("Work"));
                    workerEntity.setName(rs.getString("Name"));
                    workerEntity.setSurname(rs.getString("Surname"));
                    workerEntity.setAddress(rs.getString("Address"));
                    workerEntity.setLocation(rs.getString("Location"));
                    workerList.add(workerEntity);
                }
                rs.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return workerList;
    }


    public void addSlots(String email, String slot1, String slot2, String slot3, String slot4, String slot5, String dateCalendar) throws TimeSlotAlreadyExistsException {
        try (Connection con = getConnector()) {
            if (con == null)
                throw new SQLException();
            String query = "INSERT INTO `databaseispw`.`appointment avaible` (`email`,`slot1`, `slot2`,`slot3`,`slot4`,`slot5`,`date`) VALUES (?, ?, ?, ?, ?, ?, ?);";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, slot1);
                preparedStatement.setString(3, slot2);
                preparedStatement.setString(4, slot3);
                preparedStatement.setString(5, slot4);
                preparedStatement.setString(6, slot5);
                preparedStatement.setString(7, String.valueOf(dateCalendar));

                preparedStatement.executeUpdate();
                SlotHoursEntity slot = new SlotHoursEntity();
                slot.setEmail(email);
                slot.setSlot1(slot1);
                slot.setSlot2(slot2);
                slot.setSlot3(slot3);
                slot.setSlot4(slot4);
                slot.setSlot5(slot5);
                slot.setDateCalendar(dateCalendar);

            }

        } catch (SQLIntegrityConstraintViolationException e) {
            throw new TimeSlotAlreadyExistsException("Lo slot selezione è già esistente");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
/*
query originale
    public void getSlots(String email, String dateCalendar) throws TimeSlotAlreadyExistsException {
        try (Connection con = getConnector()) {
            if (con == null)
                throw new SQLException();
            String query = "SELECT * FROM `databaseispw`.`appointment avaible` WHERE email= ? AND date= ? ;";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setString(1, email);
               // preparedStatement.setString(2, String.valueOf(dateCalendar));
                ResultSet rs = preparedStatement.executeQuery();
                if (!rs.next()) {
                    throw new TimeSlotAlreadyExistsException("Lo slot selezione è già esistente");
                }


                SlotHoursEntity slot = new SlotHoursEntity();
                slot.setEmail(rs.getString("email"));
                slot.setSlot1(rs.getString("slot1"));
                slot.setSlot2(rs.getString("slot2"));
                slot.setSlot3(rs.getString("slot3"));
                slot.setSlot4(rs.getString("slot4"));
                slot.setSlot5(rs.getString("slot5"));
                slot.setDateCalendar(rs.getString("dateCalendar"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }*/


    // query di prova
    public SlotHoursEntity getSlots(String email, String dateCalendar)   {
        SlotHoursEntity slot = null;
        try (Connection con = getConnector()) {
            if (con == null)
                throw new SQLException();

            String query = "SELECT * FROM `databaseispw`.`appointment avaible` WHERE email = ? AND date = ?";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, dateCalendar);

                try (ResultSet rs = preparedStatement.executeQuery()) {
                    if (rs.next()) {
                        slot =  SlotHoursEntity.getInstance();
                        slot.setEmail(rs.getString("email"));
                        slot.setSlot1(rs.getString("slot1"));
                        slot.setSlot2(rs.getString("slot2"));
                        slot.setSlot3(rs.getString("slot3"));
                        slot.setSlot4(rs.getString("slot4"));
                        slot.setSlot5(rs.getString("slot5"));
                        slot.setDateCalendar(rs.getString("date"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return slot;
    }
}