package com.example.progetto_ispw.notifications;

import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.user.UserDAO;
import com.example.progetto_ispw.worker.InfoAppoinEntity;
import com.example.progetto_ispw.worker.WorkerDAO;
import com.example.progetto_ispw.workerprofile.AppointmentResultElement;
import com.example.progetto_ispw.workerprofile.AppointmentResultEntity;

import java.util.List;

public class NotificationsController {

    private AppointmentResultEntity appointmentResultSet = new AppointmentResultEntity();
    public boolean verifica(NotificationsBean bean) {
        InfoAppoinEntity infoAppoinEntity = new InfoAppoinEntity();
        WorkerDAO dao = WorkerDAO.getInstance();
        String e = bean.getemailsearch();
        List<InfoAppoinEntity> appointmentList = dao.getAppointmentforWoker(e);
        if (appointmentList.isEmpty() ) {
            System.out.println("query nel ctrl:"+dao.getAppointmentforWoker(e));
            //System.out.println("query nel ctrl:"+infoAppoinEntity.getAccept());
            return false;
        } else {

            for (InfoAppoinEntity appointment : appointmentList) {
                //costruiamo AppointmentResultElement
                if (appointment.getAccept() == 0) {
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
                }
            } if (!this.appointmentResultSet.getElements().isEmpty()) {
                bean.setAppointmentResultSet(this.appointmentResultSet);
                return true;
            } else {
                return false;
            }

            //ho preso la lista degli appuntamenti, vedere cosa deve tornare e capire cosa deve fare se non ci sono risultat
        }
    }

    public void deleteAppo(String date, String time, String email) {
        WorkerDAO dao=WorkerDAO.getInstance();
        dao.deleteAppointment(email,date,time);
    }

    public void acceptMethod(String date, String time, String email) {
        WorkerDAO dao= WorkerDAO.getInstance();
        dao.updateAppointmentStatus(email, date, time);
    }

    public void searchInfo(NotificationsBean bean) throws UserNotFoundException {
        UserDAO userDAO= UserDAO.getInstance();
        userDAO.getUserInfo(bean.getemailsearch());
    }
}
