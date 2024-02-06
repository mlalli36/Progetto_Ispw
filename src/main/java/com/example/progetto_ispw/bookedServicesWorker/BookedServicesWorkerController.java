package com.example.progetto_ispw.bookedServicesWorker;

import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.user.UserDAO;
import com.example.progetto_ispw.worker.InfoAppoinEntity;
import com.example.progetto_ispw.worker.WorkerDAO;
import com.example.progetto_ispw.workerprofile.AppointmentResultElement;
import com.example.progetto_ispw.workerprofile.AppointmentResultEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static com.example.progetto_ispw.utile.DBConnector.getConnector;

public class BookedServicesWorkerController {

    private AppointmentResultEntity appointmentResultSet = new AppointmentResultEntity();

    public void searchInfo(BookedServicesWorkerBean bean) throws UserNotFoundException {
        UserDAO userDAO = UserDAO.getInstance();
        userDAO.getUserInfo(bean.getemailsearch());
    }

    public boolean verifica(BookedServicesWorkerBean bean) {

        WorkerDAO dao = WorkerDAO.getInstance();
        String e = bean.getemailsearch();
        List<InfoAppoinEntity> appointmentList=dao.getAppointmentforWokerUser(e);
        if(appointmentList.isEmpty()){
            return false;

        }else{
            for (InfoAppoinEntity appointment : appointmentList) {

                AppointmentResultElement appointmentResultElement = new AppointmentResultElement();
                appointmentResultElement.setWorkerEmail(appointment.getWEmail());
                appointmentResultElement.setClientName(appointment.getCName());
                appointmentResultElement.setClientSurname(appointment.getCSurname());
                appointmentResultElement.setClientEmail(appointment.getCEmail());
                appointmentResultElement.setDateAppointment(appointment.getDAppo());
                appointmentResultElement.setClientNumber(appointment.getCNumber());
                appointmentResultElement.setDescription(appointment.getdescriptionWork());
                appointmentResultElement.setTime(appointment.getTime());



                this.appointmentResultSet.addElement(appointmentResultElement);

            } if (!this.appointmentResultSet.getElements().isEmpty()) {
                bean.setAppointmentResultSet(this.appointmentResultSet);
                return true;
            } else {
                return false;
            }


    }}



    public void deleteAppoW(String email, String date, String time) {
         UserDAO dao= UserDAO.getInstance();
        dao.deleteAppointment(email,date,time);

        }

}
