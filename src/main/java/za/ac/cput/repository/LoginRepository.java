/*
LoginRepository.java
Repository class for the Login
Author: Ameer Samsodien (220005060)
Date : 6 April 2022
*/

package za.ac.cput.repository;

import za.ac.cput.entity.Login;
import java.util.HashSet;
import java.util.Set;

public class LoginRepository implements ILoginRepository{

    private static LoginRepository repository = null;
    private Set<Login> loginDB = null;

    private LoginRepository() {loginDB = new HashSet<Login>();}

    public static LoginRepository getRepository(){
        if(repository == null){
            repository = new LoginRepository();
        }
        return repository;
    }

    @Override
    public Login create(Login login){
        boolean success = loginDB.add(login);
        if(!success)
            return null;
        return login;
    }

    @Override
    public Login read(String loginId){
        for (Login login : loginDB){
            if(login.getLoginId().equals(loginId))
                return login;
        }
        return null;
    }

    @Override
    public Login update(Login login){
        Login oldLogin = read(login.getLoginId());
        if (oldLogin != null) {
            loginDB.remove(oldLogin);
            loginDB.add(login);
            return login;
        }
        return null;
    }

    @Override
    public boolean delete(String loginId){
        Login loginToDelete = read(loginId);
        if(loginToDelete == null)
            return false;
        loginDB.remove(loginToDelete);
        return true;
    }

    @Override
    public Set<Login> getAll(){return loginDB;}

}

