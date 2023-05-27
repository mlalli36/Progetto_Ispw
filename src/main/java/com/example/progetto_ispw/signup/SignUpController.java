package com.example.progetto_ispw.signup;


import com.example.progetto_ispw.user.UserDAO;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.salt.ZeroSaltGenerator;

public class SignUpController {

    private static final String ENCRYPTION_KEY = "ISPWPROJECTWORKERLINK2023";


    public void signUpUser(SignUpBean bean) throws UserAlreadyExistsException, DifferentPasswordException {
        UserDAO dao = UserDAO.getInstance();
        String checkedPassword;
        if (!bean.getPsw().equals(bean.getConfirmPsw()))
            throw new DifferentPasswordException();
        checkedPassword = bean.getPsw(); //Se sono uguali è indifferente scegliere la prima o la seconda
        String encryptedPassword = this.encryptPassword(checkedPassword);
        String tipoaccesso = bean.isWorker() ? "Worker" : "Client";
        dao.addUser(bean.getEmail(), encryptedPassword,tipoaccesso);
       // UserEntity user = UserEntity.getInstance();
    }


    private String encryptPassword(String psw) { //Viene passata la stringa da criptare
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(ENCRYPTION_KEY); //chiave per criptare la psw
        encryptor.setSaltGenerator(new ZeroSaltGenerator());
        //Non utilizzare salt per l'encryption, così da avere
        //risultati uguali ogni volta che si cripta e decripta la
        //la stessa parola

        return encryptor.encrypt(psw);
    }
}

