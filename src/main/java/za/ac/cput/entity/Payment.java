package za.ac.cput.entity;

/*  Payment.java Entity for the Payment
    Author: Shasta Storme Abrahams (217059376)
    Date: 26 March 2022
*/

public class Payment {
    private String clientNum;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNum;

    private Payment() {

    }

    private Payment(Builder builder) {
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

    public void setClientNum(String clientNum) {
        this.clientNum = clientNum;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "Payment{" +
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

        public Builder copy(Payment payment) {
            this.clientNum = payment.clientNum;
            this.firstName = payment.firstName;
            this.lastName = payment.lastName;
            this.email = payment.email;
            this.phoneNum = payment.phoneNum;
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }
    }
}
