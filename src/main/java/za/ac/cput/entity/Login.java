/*
Login.java
Entity for the Login
Author: Ameer Samsodien (220005060)
Date : 27 March 2022
*/

package za.ac.cput.entity;

public class Login {

    private String loginId;
    private String adminNum;
    private String adminPassword;

    private Login(){

    }

    private Login(Builder builder){
        this.loginId = builder.loginId;
        this.adminNum = builder.adminNum;
        this.adminPassword = builder.adminPassword;

    }

    public String getLoginId(){return loginId;}
    public void setLoginId(String loginId) {this.loginId = loginId;}

    public String getAdminNum(){return adminNum;}
    public void setAdminNum(String adminNum) {this.adminNum = adminNum;}

    public String getAdminPassword(){return adminPassword;}
    public void setAdminPassword(String adminPassword) {this.adminPassword = adminPassword;}


    @Override
    public String toString() {
        return "Login{" +
                "loginId='" + loginId + '\'' +
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
            this.loginId = login.loginId;
            this.adminNum = login.adminNum;
            this.adminPassword = login.adminPassword;
            return this;
        }

        public Login build(){return new Login(this);}
    }

}
