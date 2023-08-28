package com.example.progetto_ispw.commandline;

public class CLController {
    private static CLController istance= null;
     public static CLController getInstance(){
         if(istance==null)
             istance=new CLController();
         return istance;
     }
    private CLController(){}
    public void loadHomeScreen(){
         HomeScreenCL homesCL=HomeScreenCL.getInstance();
         homesCL.showCLHomeScreen();
    }

    public void showSignUp(){
         SignUpCL signUpCL = new SignUpCL();
         signUpCL.signUserUp();
    }

    public void showSearchScreen() {
        SearchScreenCL searchScreenCL = new SearchScreenCL();
        searchScreenCL.searchFromCL();
     }
}
