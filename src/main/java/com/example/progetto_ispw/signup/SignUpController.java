package com.example.progetto_ispw.signup;


import com.example.progetto_ispw.login.LoginBean;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.signup.exception.DifferentPasswordException;
import com.example.progetto_ispw.signup.exception.UserAlreadyExistsException;
import com.example.progetto_ispw.user.UserDAO;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.salt.ZeroSaltGenerator;

public class SignUpController {

    private static final String ENCRYPTION_KEY = System.getProperty("p.key");


    public void signUpUser(SignUpBean bean) throws UserAlreadyExistsException, DifferentPasswordException {
        UserDAO dao = UserDAO.getInstance();
        String checkedPassword;
        if (!bean.getPsw().equals(bean.getConfirmPsw()))
            throw new DifferentPasswordException();
        checkedPassword = bean.getPsw();
        String encryptedPassword = this.encryptPassword(checkedPassword);
        String tipoaccesso = bean.isWorker() ? "Worker" : "Client";

        dao.addUser(bean.getName(), bean.getSurname(), bean.getEmail(), encryptedPassword,tipoaccesso);
     }


    private String encryptPassword(String psw) {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(ENCRYPTION_KEY);
        encryptor.setSaltGenerator(new ZeroSaltGenerator());

        return encryptor.encrypt(psw);
    }
    public void searchInfo(LoginBean bean) throws UserNotFoundException {
        UserDAO userDAO= UserDAO.getInstance();
        userDAO.getUserInfo(bean.getEmail());
    }
}

