/*
AdminRepository.java
Repository class for the Admin
Author: Ameer Samsodien (220005060)
Date : 6 April 2022
*/

package za.ac.cput.repository;

import za.ac.cput.entity.Admin;
import java.util.HashSet;
import java.util.Set;

public class AdminRepository implements IAdminRepository{

    private static AdminRepository repository = null;
    private Set<Admin> adminDB = null;

    private AdminRepository() {adminDB = new HashSet<Admin>();}

    public static AdminRepository getRepository(){
        if(repository == null){
            repository = new AdminRepository();
        }
        return repository;
    }

    @Override
    public Admin create(Admin admin){
        boolean success = adminDB.add(admin);
        if(!success)
            return null;
        return admin;
    }

    @Override
    public Admin read(String adminNum){
        for (Admin admin : adminDB){
            if(admin.getAdminNum().equals(adminNum));
                return admin;
        }
        return null;
    }

    @Override
    public Admin update(Admin admin){
        Admin oldAdmin = read(admin.getAdminNum());
        if (oldAdmin != null){
            adminDB.remove(oldAdmin);
            adminDB.add(admin);
            return admin;
        }
        return null;
    }

    @Override
    public boolean delete(String adminNum){
        Admin adminToDelete = read(adminNum);
        if(adminToDelete == null)
            return false;
        adminDB.remove(adminToDelete);
        return true;
    }

    @Override
    public Set<Admin> getAll(){return adminDB;}

}
