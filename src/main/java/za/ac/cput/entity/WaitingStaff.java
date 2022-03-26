package za.ac.cput.entity;
/*
 * Chef.java Entity for Chef
 * Author: Imraan Abdullah
 * 219361738
 * Date: 26 March 2022
 * */
public class WaitingStaff
{
    private String employeeId;
    private String firstName;
    private String lastName;

    private WaitingStaff(Builder builder)
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
        return "WaitingStaff{" +
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

        public Builder copy(WaitingStaff waitingStaff)
        {
            this.employeeId = waitingStaff.employeeId;
            this.firstName = waitingStaff.firstName;
            this.lastName = waitingStaff.lastName;
            return this;
        }

        public WaitingStaff build()
        {
            return new WaitingStaff(this);
        }
    }
}
