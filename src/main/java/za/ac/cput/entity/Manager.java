package za.ac.cput.entity;

/* Manager.java
 Entity for the Manager
 Author: Velenkosini Prince Jeza (218191669)
 Date: 28 March 2022
*/

public class Manager {

    private String employeeId;
    private String firstName;
    private String lastName;

    public Manager() {
    }

    private Manager(Builder builder){
        this.employeeId = builder.employeeId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public static class Builder {
        private String employeeId;
        private String firstName;
        private String lastName;

        public Builder() {
        }

        public Builder setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
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

        public Builder copy(Manager manager){
            this.employeeId = manager.employeeId;
            this.firstName = manager.firstName;
            this.lastName = manager.lastName;
            return this;
        }

        public Manager build() {
            return new Manager(this);
        }
    }

    @Override
    public String toString() {
        return "Manager{" +
                "employeeId='" + employeeId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
