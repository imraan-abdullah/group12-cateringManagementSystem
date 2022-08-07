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
public class Entertainment
{
    @Id @NotNull
    private String entertainmentType;
    private int cost;

    protected Entertainment()
    {

    }
    private Entertainment(Builder builder)
    {
        this.entertainmentType = builder.entertainmentType;
        this.cost = builder.cost;
    }

    public String getEntertainmentType()
    {
        return entertainmentType;
    }

    public void setEntertainmentType(String entertainmentType)
    {
        this.entertainmentType = entertainmentType;
    }

    public int getCost()
    {
        return cost;
    }

    public void setCost(int cost)
    {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Entertainment{" +
                "entertainmentType='" + entertainmentType + '\'' +
                ", cost=" + cost +
                '}';
    }

    public static class Builder
    {
        private String entertainmentType;
        private int cost;

        public Builder setEntertainmentType(String entertainmentType)
        {
            this.entertainmentType = entertainmentType;
            return this;
        }

        public Builder setCost(int cost)
        {
            this.cost = cost;
            return this;
        }

        public Builder copy(Entertainment entertainment)
        {
            this.entertainmentType = entertainment.entertainmentType;
            this.cost = entertainment.cost;
            return this;
        }

        public Entertainment build()
        {
            return new Entertainment(this);
        }
    }
}
