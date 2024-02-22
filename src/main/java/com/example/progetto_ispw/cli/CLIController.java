package com.example.progetto_ispw.cli;

import com.example.progetto_ispw.UIController;
import com.example.progetto_ispw.bookedServicesUser.BookedServicesUserView;
import com.example.progetto_ispw.home.HomeBean;
import com.example.progetto_ispw.home.HomeController;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.savehoursslots.SlotHoursView;
import com.example.progetto_ispw.user.UserEntity;

import java.io.IOException;

public class CLIController {
    private static CLIController istance = null;

    public static CLIController getIstance() {
        if (istance == null)
            istance = new CLIController();
        return istance;
    }
    public void loadHomeScreen() throws UserNotFoundException, IOException {
        HomeScreenCLI homeScreenCLI = HomeScreenCLI.getInstance();
        homeScreenCLI.showHome();


    }

    public void showSignUp(){
        SignUpCLI signUpCLI = new SignUpCLI();
        signUpCLI.signUserUp();
    }

    public void insertInfoUser(String namesearch, String surnamesearch, String emailsearch) {

        UserProfileCLI userProfileCLI= new UserProfileCLI();
        userProfileCLI.userProfile();
    }
    public void insertInfoWorker(String namesearch, String surnamesearch, String emailsearch) throws UserNotFoundException, IOException {

        WorkerProfileCLI workerProfileCLI = new WorkerProfileCLI();
        workerProfileCLI.showWorkerProfile();
    }
    public void showForm(String emailWorker, String emailC, String nameC, String surnameC) throws UserNotFoundException, IOException {
        FormCLI formCLI= new FormCLI();
        formCLI.showFillForm(emailWorker,emailC,nameC,surnameC);
    }

    public void showProfile()throws UserNotFoundException, IOException {
        UserEntity user = UserEntity.getInstance();
        String emailsearch= user.getEmail();
        String type = user.getTipoaccesso();

        CLIController viewController = CLIController.getIstance();//è singletone
        String namesearch= user.getName();
        String surnamesearch= user.getSurname();
        HomeBean hBean=new HomeBean();
        hBean.setEmail(emailsearch);
        HomeController hController =new HomeController();
        hController.searchInfo(hBean);





        if(!"Worker".equals(type)) {

            viewController.insertInfoUser(namesearch,surnamesearch,emailsearch);
        } else{


            viewController.insertInfoWorker(namesearch,surnamesearch,emailsearch);
        }
    }

    public void showBookedServicesUser(String namesearch, String surnamesearch, String emailsearch) {
        BookedServicesUserCLI bookedServicesUserCLI = new BookedServicesUserCLI();
        bookedServicesUserCLI.bookedServicesMethod();
    }

    public void showBookedServicesWorker(String namesearch, String surnamesearch, String emailsearch) {
        BookedServicesWorkerCLI bookedServicesWorkerCLI = new BookedServicesWorkerCLI();
        bookedServicesWorkerCLI.bookedServicesMethod();
    }

    public void showSlotHours(String namesearch, String surnamesearch, String emailsearch) {
        SlotHoursCLI slotHoursCLI= new SlotHoursCLI();
        slotHoursCLI.slotHoursMethod(emailsearch);
    }

    public void showNotifications(String namesearch, String surnamesearch, String emailsearch)  {
        NotificationCLI notificationCLI= new NotificationCLI();
        notificationCLI.notificationMethod();
    }

    public void showMyDetailsWorker(String namesearch, String surnamesearch, String emailsearch) throws IOException {
        MyDetailsCLI myDetailsCLI= new MyDetailsCLI();
        myDetailsCLI.myDetailsMethod(namesearch,surnamesearch,emailsearch);
    }

    public void showAppointmentAccepted() {
        AppointmentAcceptedCLI appointmentAccepted= new AppointmentAcceptedCLI();
        appointmentAccepted.appointmentAcceptedMethod();
    }
}
