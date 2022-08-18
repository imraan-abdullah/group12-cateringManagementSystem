package za.ac.cput.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/*
* Chef.java Entity for Chef
* Author: Imraan Abdullah
* 219361738
* Date: 26 March 2022
* */
@Entity
public class Entertainment implements Serializable
{
    @Id @NotNull private String entertainmentType;
    @NotNull private int cost;

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

    public int getCost()
    {
        return cost;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entertainment that = (Entertainment) o;
        return cost == that.cost && entertainmentType.equals(that.entertainmentType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entertainmentType, cost);
    }

    @Override
    public String toString() {
        return "Entertainment{" +
                "entertainmentType='" + entertainmentType + '\'' +
                ", cost=" + cost +
                '}';
    }
}
