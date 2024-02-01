package com.example.progetto_ispw.cli;

import com.example.progetto_ispw.UIController;
import com.example.progetto_ispw.bookedServicesUser.BookedServicesUserView;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.savehoursslots.SlotHoursView;
import com.example.progetto_ispw.searchdinamica.SearchDinamicaBean;
import com.example.progetto_ispw.searchdinamica.SearchDinamicaController;
import com.example.progetto_ispw.user.UserEntity;

import java.io.IOException;

public class CLIController {
    private static CLIController istance = null;

    public static CLIController getIstance() {
        if (istance == null)
            istance = new CLIController();
        return istance;
    }
    public void loadHomeScreen(){
        HomeScreenCLI homeScreenCLI = HomeScreenCLI.getInstance();
        homeScreenCLI.homeMenu();


    }

    public void showSignUp(){
        SignUpCLI signUpCLI = new SignUpCLI();
        signUpCLI.signUserUp();
    }

    public void insertInfoUser(String namesearch, String surnamesearch, String emailsearch) {
      /*  System.out.println("User Profile:");
        System.out.println("Name: " + namesearch);
        System.out.println("Surname: " + surnamesearch);
        System.out.println("Email: " + emailsearch);*/
        UserProfileCLI userProfileCLI= new UserProfileCLI();
        userProfileCLI.userProfile();
    }
    public void insertInfoWorker(String namesearch, String surnamesearch, String emailsearch) {
       /* System.out.println("Worker Profile:");
        System.out.println("Name: " + namesearch);
        System.out.println("Surname: " + surnamesearch);
        System.out.println("Email: " + emailsearch);*/
        WorkerProfileCLI workerProfileCLI = new WorkerProfileCLI();
        workerProfileCLI.workerProfile();
    }
    public void showForm(String emailWorker, String emailC, String nameC, String surnameC){
        FormCLI formCLI= new FormCLI();
        formCLI.fillForm(emailWorker,emailC,nameC,surnameC);
    }

    public void showProfile()throws UserNotFoundException, IOException {
        UserEntity user = UserEntity.getInstance();
        String emailsearch= user.getEmail();
        String type = user.getTipoaccesso();
        System.out.println(type);
        CLIController viewController = CLIController.getIstance();//è singletone
        String namesearch= user.getName();
        String surnamesearch= user.getSurname();
        SearchDinamicaBean searchDBean=new SearchDinamicaBean();
        searchDBean.setEmail(emailsearch);
        SearchDinamicaController searchDController =new SearchDinamicaController();
        searchDController.searchInfo(searchDBean);


        System.out.println("namesearch "+namesearch);
        System.out.println("surnamesearch "+surnamesearch);


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

    public void showNotifications(String namesearch, String surnamesearch, String emailsearch) {
        NotificationCLI notificationCLI= new NotificationCLI();
        notificationCLI.notificationMethod();
    }

    public void showMyDetailsWorker(String namesearch, String surnamesearch, String emailsearch) throws IOException {
        MyDetailsCLI myDetailsCLI= new MyDetailsCLI();
        myDetailsCLI.myDetailsMethod();
    }
}
