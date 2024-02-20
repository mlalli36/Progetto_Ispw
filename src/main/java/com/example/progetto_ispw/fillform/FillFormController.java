package com.example.progetto_ispw.fillform;

import com.example.progetto_ispw.fillform.exception.*;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.savehoursslots.SlotHoursEntity;
import com.example.progetto_ispw.user.UserDAO;
import com.example.progetto_ispw.worker.InfoAppoinEntity;
import com.example.progetto_ispw.worker.WorkerDAO;


public class FillFormController {

    public void fill(FillFormBean bean) {
        WorkerDAO dao = WorkerDAO.getInstance();

        if(bean.getTime()==null){
            throw new NotValidTimeException("");
        }
        InfoAppoinEntity info =  dao.getAppointment(bean.getEmailWorker(), bean.getDate(), bean.getTime());

        if(info !=null && info.getWEmail().equals(bean.getEmailWorker()) && info.getDAppo().equals(bean.getDate()) && info.getTime().equals(bean.getTime())){
            throw new TimeAlreadySelectedException("The selected time is no longer valid.");
        }
        int accept = 0;
        dao.addAppointment(bean.getEmailWorker(), bean.getName(),bean.getSurname(),bean.getEmailUser(),bean.getDate(),bean.getPhone(),bean.getDescription(),bean.getTime(), accept);

    }


    public void takeSlot(FillFormBean bean) {
        String emailWorker = bean.getEmailWorker();
        String date = bean.getDate();



        WorkerDAO dao = WorkerDAO.getInstance();
        SlotHoursEntity result =  SlotHoursEntity.getInstance();
        result = dao.getSlots(emailWorker, date);
        System.out.println("result: "+result);
    }

    public void searchInfo(FillFormBean fillForm) throws UserNotFoundException {
        UserDAO userDAO= UserDAO.getInstance();
        userDAO.getUserInfo(fillForm.getemailsearch());
    }
}
