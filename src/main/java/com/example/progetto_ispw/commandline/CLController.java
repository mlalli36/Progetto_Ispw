package com.example.progetto_ispw.commandline;

import com.example.progetto_ispw.StartApp;
import com.example.progetto_ispw.UIController;
import com.example.progetto_ispw.bookedServicesUser.BookedServicesUserView;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.searchdinamica.SearchDinamicaBean;
import com.example.progetto_ispw.searchdinamica.SearchDinamicaController;
import com.example.progetto_ispw.user.UserEntity;
import com.example.progetto_ispw.userprofile.UserProfileView;

import java.io.IOException;
import java.util.Scanner;
/*
public class CLController {
    private static CLController istance= null;
     public static CLController getInstance(){
         if(istance==null)
             istance=new CLController();
         return istance;
     }
    private CLController(){}
    public void loadHomeScreen() throws UserNotFoundException, IOException {
         HomeScreenCL homesCL=HomeScreenCL.getInstance();
         homesCL.showCLHomeScreen();
    }

    public void showSignUp(){
         SignUpCL signUpCL = new SignUpCL();
         signUpCL.signUserUp();
    }

    public void showSearchScreen() {
        SearchScreenCL searchScreenCL = new SearchScreenCL();
       // searchScreenCL.searchFromCL();
     }

    public void insertInfoUserScreen(String namesearch, String surnamesearch, String emailsearch) throws UserNotFoundException, IOException {
      
        UserProfileCL usCL = new UserProfileCL();
        usCL.preCompileUser(namesearch, surnamesearch,emailsearch);
        usCL.choice();
    }

    public void ExitScreen() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to return to login? (yes/no)");
        String choice = scanner.nextLine().toLowerCase();

        if ("yes".equals(choice)) {
            StartCommandLine.logUser(); // Chiamare nuovamente il metodo logUser() per tornare al login
        } else {
            System.exit(0); // Altrimenti, uscire dal programma
        }

        
    }

    public void showBookedServicesUserScreen(String namesearch, String surnamesearch, String emailsearch) {

        BookedServicesUserCL bsuCL = new BookedServicesUserCL();
        bsuCL.precompileUser(namesearch,surnamesearch,emailsearch);
        bsuCL.bookServicesMethod();
     }

    public void profileScreen() throws UserNotFoundException, IOException {
        UserEntity user = UserEntity.getInstance();
        String emailsearch= user.getEmail();
        String type = user.getTipoaccesso();
        System.out.println(type);
        CLController clC = CLController.getInstance();
        String namesearch= user.getName();
        String surnamesearch= user.getSurname();
        SearchDinamicaBean searchDBean=new SearchDinamicaBean();
        searchDBean.setEmail(emailsearch);
        SearchDinamicaController searchDController =new SearchDinamicaController();
        searchDController.searchInfo(searchDBean);


        System.out.println("namesearch "+namesearch);
        System.out.println("surnamesearch "+surnamesearch);


        if(!"Worker".equals(type)) {

            clC.insertInfoUserScreen(namesearch,surnamesearch,emailsearch);
        } else{


            clC.insertInfoWorkerScreen(namesearch,surnamesearch,emailsearch);
        }
    }

    public void insertInfoWorkerScreen(String namesearch, String surnamesearch, String emailsearch) {
    }
}
*/