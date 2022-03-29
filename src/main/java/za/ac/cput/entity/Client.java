package za.ac.cput.entity;

/*Client.java Entity for the Client
Author: Mariam Gallie (219094837)
Date: 26 March 2022
*/

public class Client {
    private String clientNum;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNum;

    private Client(){}

    private Client(Client.Builder builder) {
        this.clientNum = builder.clientNum;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.phoneNum = builder.phoneNum;
    }

    public String getClientNum() {
        return clientNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientNum='" + clientNum + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }
    public static class Builder {
        private String clientNum;
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNum;

        public Builder setClientNum(String clientNum) {
            this.clientNum = clientNum;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhoneNum(String phoneNum) {
            this.phoneNum = phoneNum;
            return this;
        }
        public Builder copy(Client client) {
            this.clientNum = client.clientNum;
            this.firstName = client.firstName;
            this.lastName = client.lastName;
            this.email = client.email;
            this.phoneNum = client.phoneNum;
            return this;

        }
        public Client build(){
            return new Client(this);
        }
    }
}
