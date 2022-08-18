package za.ac.cput.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/* Manager.java
 Entity for the Manager
 Author: Velenkosini Prince Jeza (218191669)
 Date: 28 March 2022
*/
@Entity
public class Manager {

    @Id @NotNull private String employeeId;
    @NotNull private String firstName;
    @NotNull private String lastName;

    protected Manager() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return employeeId.equals(manager.employeeId) && firstName.equals(manager.firstName) && lastName.equals(manager.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, firstName, lastName);
    }
}
