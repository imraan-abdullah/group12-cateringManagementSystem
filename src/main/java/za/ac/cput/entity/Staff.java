package za.ac.cput.entity;

/* Staff.java
 Entity for the Staff
 Author: Velenkosini Prince Jeza (218191669)
 Date: 28 March 2022
*/

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Staff {

    @Id @NotNull private String employeeId;
    @NotNull private String firstName;
    @NotNull private String lastName;
    @NotNull private String staffType;

    protected Staff() {
    }

    private Staff(Staff.Builder builder){
        this.employeeId = builder.employeeId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.staffType = builder.staffType;
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

    public String getStaffType() {
        return staffType;
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

    public void setStaffType(String staffType) {
        this.staffType = staffType;
    }

    public static class Builder {
        private String employeeId;
        private String firstName;
        private String lastName;
        private String staffType;

        public Builder() {
        }

        public Staff.Builder setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Staff.Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Staff.Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Staff.Builder setStaffType(String staffType) {
            this.staffType = staffType;
            return this;
        }

        public Staff.Builder copy(Staff staff){
            this.employeeId = staff.employeeId;
            this.firstName = staff.firstName;
            this.lastName = staff.lastName;
            this.staffType = staff.staffType;
            return this;
        }

        public Staff build() {
            return new Staff(this);
        }
    }

    @Override
    public String toString() {
        return "Staff{" +
                "employeeId='" + employeeId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", staffType='" + staffType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return employeeId.equals(staff.employeeId) && firstName.equals(staff.firstName) && lastName.equals(staff.lastName) && staffType.equals(staff.staffType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, firstName, lastName, staffType);
    }
}
