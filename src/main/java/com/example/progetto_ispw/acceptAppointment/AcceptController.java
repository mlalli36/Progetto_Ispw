package com.example.progetto_ispw.acceptAppointment;

import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.user.UserDAO;
import com.example.progetto_ispw.worker.InfoAppoinEntity;
import com.example.progetto_ispw.worker.WorkerDAO;
import com.example.progetto_ispw.workerprofile.AppointmentResultElement;
import com.example.progetto_ispw.workerprofile.AppointmentResultEntity;

import java.util.List;

public class AcceptController {
    private AppointmentResultEntity appointmentResultSet = new AppointmentResultEntity();
    public boolean verifica(AcceptBean bean) {
        InfoAppoinEntity infoAppoinEntity = new InfoAppoinEntity();
        WorkerDAO dao = WorkerDAO.getInstance();
        String e = bean.getemailsearch();
        List<InfoAppoinEntity> appointmentList = dao.getAppointmentforWoker(e);
        if (appointmentList.isEmpty() ) {
              return false;
        } else {

            for (InfoAppoinEntity appointment : appointmentList) {

                if (appointment.getAccept() == 1) {
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

    public void checkStateAppointment(String date, String time, String email){
        WorkerDAO dao= WorkerDAO.getInstance();
        dao.getAppointment(email,date,time);
    }
    public void searchInfo(AcceptBean bean) throws UserNotFoundException {
        UserDAO userDAO= UserDAO.getInstance();
        userDAO.getUserInfo(bean.getemailsearch());
    }


}
