package com.example.progetto_ispw.commandline;

import com.example.progetto_ispw.UIController;
import com.example.progetto_ispw.home.HomeBean;
import com.example.progetto_ispw.home.HomeController;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.searchdinamica.SearchDinamicaController;
import com.example.progetto_ispw.user.UserEntity;
import com.example.progetto_ispw.worker.WorkerEmailEntity;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.*;
/*
public class HomeScreenCL {
    private static HomeScreenCL instance =null;
    private final UserEntity user = UserEntity.getInstance();

    private HomeScreenCL(){}

    public static  HomeScreenCL getInstance(){
        if(HomeScreenCL.instance==null) instance = new HomeScreenCL();
        return instance;
    }

    public void showCLHomeScreen() throws IOException, UserNotFoundException {
        int selectedOption;
        while((selectedOption = showOptions())<0){
            //esegui showOptions finché l'utente non sceglie un'opzione corretta o non termina il programma
        }
        switch(selectedOption){
            case 1:{
                     String job;
                     String location;
                     out.println("Insert the job of the craftsman you need:");
                     Scanner inputJ= new Scanner(in);
                     job= inputJ.nextLine();
                     out.println("Insert the location:");
                     Scanner inputL= new Scanner(in);
                     location=inputL.nextLine();

                     HomeBean bean = new HomeBean();
                     bean.setJobWork(job);
                     bean.setLocationWork(location);

                SearchDinamicaController ctrl = new SearchDinamicaController();
                ctrl.workInfo(bean);
                break;}

            case 2:{
                UserEntity user = UserEntity.getInstance();
                String type = user.getTipoaccesso();
                System.out.println(type);

                CLController clc= CLController.getInstance();
                String emailsearch= user.getEmail();
                HomeBean homeBean=new HomeBean();
                homeBean.setEmail(emailsearch);
                HomeController homeController=new HomeController();
                homeController.searchInfo(homeBean);
                String namesearch= user.getName();
                String surnamesearch= user.getSurname();
                if(!"Worker".equals(type)){
                    //profilo user
                    clc.insertInfoUserScreen(namesearch,surnamesearch,emailsearch);
                    break;

                }else{
                    //profilo worker
                    WorkerEmailEntity wkE= WorkerEmailEntity.getInstance();
                    wkE.setEmailWEE(emailsearch);
                    clc.insertInfoWorkerScreen(namesearch,surnamesearch,emailsearch);
                    break;

                }

                   }
            case 3:{
                    System.exit(0);
                    break;
                }
            default:{/* Non è necessario gestire altri casi perché sono già gestiti dal ciclo while  */
/*}
        }
        }


    private int showOptions(){
        out.println("""
                                        WELCOME TO WORKERLINK

                Select what you want to do (insert the number):
                
                1) Search the craftsman you need 
                2) Open your profile
                3) Quit application"""

);
        Scanner scanner = new Scanner(in);
        int selectedOption = scanner.nextInt();
        if(selectedOption >4 || selectedOption<1){
            err.println("Invalid option, try option!");
            return -1;
        }
 return selectedOption;   }

}
*/