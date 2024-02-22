package com.example.progetto_ispw.worker;

import com.example.progetto_ispw.savehoursslots.SlotHoursEntity;
import com.example.progetto_ispw.savehoursslots.exception.TimeSlotAlreadyExistsException;
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

    public void addWorker(String email, String description, String work, String nome, String cognome, String indirizzo, String location, Double lat, Double lng) throws UserAlreadyExistsException {
        try (Connection con = getConnector()) {
            if (con == null)
                throw new SQLException();
            String query = "INSERT INTO `databaseispw`.`tabellainformazioni` (`Email`,`Description`,`Work`, `Name`,`Surname`,`Address`,`Location`, `Lat`, `Lng` ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, description);
                preparedStatement.setString(3, work);
                preparedStatement.setString(4, nome);
                preparedStatement.setString(5, cognome);
                preparedStatement.setString(6, indirizzo);
                preparedStatement.setString(7, location);
                preparedStatement.setDouble(8, lat);
                preparedStatement.setDouble(9, lng);


                preparedStatement.executeUpdate();
                WorkerEntity worker = new WorkerEntity();
                worker.setEmail(email);
                worker.setDescription(description);
                worker.setWork(work);
                worker.setName(nome);
                worker.setSurname(cognome);
                worker.setAddress(indirizzo);
                worker.setLocation(location);
                worker.setCoordinates(lat,lng);

            }

        } catch (SQLIntegrityConstraintViolationException e) {
            throw new UserAlreadyExistsException();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public List<WorkerEntity> getWorker(String jobWorker, double userLat, double userLng, int radius, String date) {
        List<WorkerEntity> workerList = new ArrayList<>();

        try {
            Connection con = getConnector();
            if (con == null)
                throw new SQLException();
            String query = """
                    SELECT * , 2*6371 * asin(sqrt(0.5 - cos((Lat-?) * 0.0174532925199432)/2 +
                                    cos(? * 0.0174532925199432) * cos(Lat * 0.0174532925199432) *
                                            (1 - cos((Lng - ?) * 0.0174532925199432))/2)) AS distance
                    FROM `tabellainformazioni` ti
                    JOIN `appointmentavaible` aa ON ti.email = aa.email
                    WHERE ti.Work = ? AND aa.date = ?
                     HAVING distance < ?
                    ORDER BY distance
                    """;

            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setDouble(1, userLat);
                preparedStatement.setDouble(2, userLat);
                preparedStatement.setDouble(3, userLng);
                preparedStatement.setString(4, jobWorker);
                preparedStatement.setString(5, date);
                preparedStatement.setInt(6, radius);

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
                    workerEntity.setDistance(rs.getDouble("distance"));
                    workerEntity.setAvability(rs.getDouble("Availability"));
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
            String query = "INSERT INTO `databaseispw`.`appointmentavaible` (`email`,`slot1`, `slot2`,`slot3`,`slot4`,`slot5`,`date`,`Availability`) VALUES (?, ?, ?, ?, ?, ?, ?,5);";
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
                slot.setAvaibility(5);
                slot.setDateCalendar(dateCalendar);

            }

        } catch (SQLIntegrityConstraintViolationException e) {
            throw new TimeSlotAlreadyExistsException("Lo slot selezionato è già esistente");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    public void addAppointment(String workerEmail,String clientName,String clientSurname,String clientEmail,String dateAppoint, String clientNumber, String workDescr, String timeDate, Integer accept){
        try (Connection con = getConnector()) {
            if (con == null)
                throw new SQLException();
            String query = "INSERT INTO `databaseispw`.`appointment_request` (`Worker_email`,`Client_name`, `Client_surname`,`Client_email`,`Date_appointment`,`Client_number`,`Work_description`,`Time_date`, `Accept`) VALUES (?, ?, ?, ?, ?, ?,?, ?, ?);";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setString(1, workerEmail);
                preparedStatement.setString(2, clientName);
                preparedStatement.setString(3, clientSurname);
                preparedStatement.setString(4, clientEmail);
                preparedStatement.setString(5, dateAppoint);
                preparedStatement.setString(6, clientNumber);
                preparedStatement.setString(7, workDescr);
                preparedStatement.setString(8, timeDate);
                preparedStatement.setInt(9, accept);
                preparedStatement.executeUpdate();

                 InfoAppoinEntity IAE = new InfoAppoinEntity();
                IAE.setWEmail(workerEmail);
                IAE.setCname(clientName);
                IAE.setCsurname(clientSurname);
                IAE.setCEmail(clientEmail);
                IAE.setDAppo(dateAppoint);
                IAE.setCNumber(clientNumber);
                IAE.setDescription(workDescr);
                IAE.setTime(timeDate);
                IAE.setAccept(accept);
    }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public InfoAppoinEntity getAppointment(String workerEmail,String date, String time){
        InfoAppoinEntity app = null;
        try (Connection con = getConnector()) {
            if (con == null)
                throw new SQLException();

            String query = "SELECT * FROM `databaseispw`.`appointment_request` WHERE Worker_email = ? AND Date_appointment=? AND Time_date=? ";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setString(1, workerEmail);
                preparedStatement.setString(2, date);
                preparedStatement.setString(3, time);

                ResultSet rs = preparedStatement.executeQuery();
                    if (rs.next()) {
                        app = new InfoAppoinEntity();
                        app.setWEmail(rs.getString("Worker_email"));
                        app.setCname(rs.getString("Client_name"));
                        app.setCsurname(rs.getString("Client_surname"));
                        app.setCEmail(rs.getString("Client_email"));
                        app.setDAppo(rs.getString("Date_appointment"));
                        app.setCNumber(rs.getString("Client_number"));
                        app.setDescription(rs.getString("Work_description"));
                        app.setTime(rs.getString("Time_date"));
                    }
                }
            }
            catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return app;
    }

    public List<InfoAppoinEntity> getAppointmentforWoker(String email){

        List<InfoAppoinEntity> appontments =new ArrayList<>();
        try (Connection con = getConnector()) {
            if (con == null)
                throw new SQLException();

            String query = "SELECT * FROM `databaseispw`.`appointment_request` WHERE Worker_email = ?  ";
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
                    app.setAccept(rs.getInt("Accept"));
                    appontments.add(app);
                }
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return appontments;
    }
    public List<InfoAppoinEntity> getAppointmentforWokerUser(String email){

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
                    app.setAccept(rs.getInt("Accept"));
                    appontments.add(app);
                }
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return appontments;
    }



    public SlotHoursEntity getSlots(String email, String dateCalendar)   {
        SlotHoursEntity slot = null;
        try (Connection con = getConnector()) {
            if (con == null)
                throw new SQLException();

            String query = "SELECT * FROM `databaseispw`.`appointmentavaible` WHERE email = ? AND date = ?";
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



    public void deleteAppointment(String email, String date, String time) {
        try (Connection con = getConnector()) {
            if (con == null)
                throw new SQLException();

            String query = "DELETE FROM `databaseispw`.`appointment_request` WHERE Worker_email=? AND Date_appointment=? AND Time_date=?; ";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, date);
                preparedStatement.setString(3, time);

                int del= preparedStatement.executeUpdate();
                if(del>0){System.out.println("Appuntamento eliminato");}else{System.out.println("Non c'erano appuntamenti da eliminare");}

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

     public void updateAppointmentStatus(String email, String date, String time) {
            try (Connection con = getConnector()) {
                if (con == null)
                    throw new SQLException();

                String query = "UPDATE `databaseispw`.`appointment_request` SET `Accept` = 1 WHERE Worker_email=? AND Date_appointment=? AND Time_date=?;";
                try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                    preparedStatement.setString(1, email);
                    preparedStatement.setString(2, date);
                    preparedStatement.setString(3, time);

                    preparedStatement.executeUpdate();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    public int getAppointmentStatus(String email, String date, String time) throws SQLException {
        try(Connection con = getConnector()){
            if( con==null)
                throw new SQLException();

            String query= "SELECT Accept FROM `databaseispw`.`appointment_request` WHERE Worker_email=? AND Date_appointment=? AND Time_date=?; ";
            try (PreparedStatement preparedStatement= con.prepareStatement(query)){
                preparedStatement.setString(1,email);
                preparedStatement.setString(2,date);
                preparedStatement.setString(3,time);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int return_value=resultSet.getInt("Accept");

                        return return_value;
                    } else {
                         return -1;
                    }
                }

            }catch (SQLException e){
                throw  new RuntimeException(e);
            }
        }
    }

    public void updateAppointmentAvaibility(String emailWorker , String date) {
        try (Connection con = getConnector()) {
            if (con == null)
                throw new SQLException();

             int currentAvailability = getCurrentAvailability(con, emailWorker ,date );

             int newAvailability = currentAvailability - 1;

             String query = "UPDATE `databaseispw`.`appointmentavaible` SET `Availability` = ? WHERE `email` = ?  ;";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setInt(1, newAvailability);
                preparedStatement.setString(2, emailWorker);


                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        }




    private int getCurrentAvailability(Connection con,String emailWorker, String date) throws SQLException {


            String query = "SELECT `Availability` FROM `databaseispw`.`appointmentavaible` WHERE `email` = ? AND `date` =? ;";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setString(1, emailWorker);
                preparedStatement.setString(2, date);


                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getInt("Availability");
                    } else {
                        throw new SQLException("Record non trovato per email: " + emailWorker);
                    }
                }
            }
        }


}