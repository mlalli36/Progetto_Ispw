package com.example.progetto_ispw.notifications;

import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.state.AcceptState;
import com.example.progetto_ispw.state.WaitState;
import com.example.progetto_ispw.user.UserDAO;
import com.example.progetto_ispw.worker.InfoAppoinEntity;
import com.example.progetto_ispw.worker.WorkerDAO;
import com.example.progetto_ispw.workerprofile.AppointmentResultElement;
import com.example.progetto_ispw.workerprofile.AppointmentResultEntity;

import java.util.List;

public class NotificationsController {

    private AppointmentResultEntity appointmentResultSet = new AppointmentResultEntity();
    public boolean verifica(NotificationsBean bean) {
        WorkerDAO dao = WorkerDAO.getInstance();
        String e = bean.getemailsearch();
        List<InfoAppoinEntity> appointmentList = dao.getAppointmentforWoker(e);
        if (appointmentList.isEmpty() ) {
             System.out.println("query nel ctrl:"+dao.getAppointmentforWoker(e));
             return false;
        } else {

            for (InfoAppoinEntity appointment : appointmentList) {

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





        }
    }
    public void searchInfo(NotificationsBean bean) throws UserNotFoundException {
        UserDAO userDAO= UserDAO.getInstance();
        userDAO.getUserInfo(bean.getemailsearch());
    }



    private    InfoAppoinEntity infoAppoinEntity = new InfoAppoinEntity();

    public void deleteAppo(String data, String orario, String email) throws UserNotFoundException {
         infoAppoinEntity.setStatoAppuntamento(new WaitState());
         WorkerDAO dao=WorkerDAO.getInstance();
        dao.deleteAppointment(email,data, orario);
    }

    public void acceptMethod(String data, String orario, String email) throws UserNotFoundException {
         infoAppoinEntity.setStatoAppuntamento(new AcceptState());

        WorkerDAO dao= WorkerDAO.getInstance();
        dao.updateAppointmentStatus(email, data, orario);
    }
}
