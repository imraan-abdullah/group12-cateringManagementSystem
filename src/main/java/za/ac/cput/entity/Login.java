package za.ac.cput.entity;

/*
Login.java
Entity for the Login
Author: Ameer Samsodien (220005060)
Date : 27 March 2022
*/

public class Login {

    private String loginID;
    private String adminNum;
    private String adminPassword;

    private Login(){

    }

    private Login(Builder builder){
        this.loginID = builder.adminNum;
        this.adminNum = builder.adminNum;
        this.adminPassword = builder.adminPassword;

    }

    public String getLoginID(){return loginID;}
    public String getAdminNum(){return adminNum;}
    public String getAdminPassword(){return adminPassword;}

    @Override
    public String toString() {
        return "Login{" +
                "loginID='" + loginID + '\'' +
                ", adminNum='" + adminNum + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                '}';
    }

    public static class Builder{
        private String loginId;
        private String adminNum;
        private String adminPassword;

        public Builder setLoginId(String loginId){
            this.loginId = loginId;
            return this;
        }

        public Builder setAdminNum(String adminNum){
            this.adminNum = adminNum;
            return this;
        }

        public Builder setAdminPassword(String adminPassword){
            this.adminPassword = adminPassword;
            return this;
        }

        public Builder copy(Login login){
            this.loginId = login.loginID;
            this.adminNum = login.adminNum;
            this.adminPassword = login.adminPassword;
            return this;
        }

        public Login build(){return new Login(this);}
    }

}
