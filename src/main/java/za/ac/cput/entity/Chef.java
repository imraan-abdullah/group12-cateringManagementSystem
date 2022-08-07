package za.ac.cput.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/*
 * Chef.java Entity for Chef
 * Author: Imraan Abdullah
 * 219361738
 * Date: 26 March 2022
 * */
@Entity
public class Chef
{
    @NotNull @Id
    private String employeeId;
    private String firstName;
    private String lastName;

    protected Chef()
    {

    }

    private Chef(Builder builder)
    {
        this.employeeId = builder.employeeId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    public String getEmployeeId()
    {
        return employeeId;
    }

    public void setEmployeeId(String employeeId)
    {
        this.employeeId = employeeId;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Chef{" +
                "employeeId='" + employeeId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static class Builder
    {
        private String employeeId;
        private String firstName;
        private String lastName;

        public Builder setEmployeeId(String employeeId)
        {
            this.employeeId = employeeId;
            return this;
        }

        public Builder setFirstName(String firstName)
        {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName)
        {
            this.lastName = lastName;
            return this;
        }

        public Builder copy(Chef chef)
        {
            this.employeeId = chef.employeeId;
            this.firstName = chef.firstName;
            this.lastName = chef.lastName;
            return this;
        }

        public Chef build()
        {
            return new Chef(this);
        }

    }
}
