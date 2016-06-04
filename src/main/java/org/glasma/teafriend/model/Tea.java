package org.glasma.teafriend.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tea")
public class Tea extends NamedEntity {

    @Column(name = "category")
    @NotEmpty
    private String category;

    @Column(name = "country")
    @NotEmpty
    private String country;

    @Column(name = "country")
    @NotEmpty
    private String description;

    @Column(name = "rate")
    private int rate;

    @Column(name = "count_connoisseurs")
    private int countConnoisseurs;

    public Tea(){}

    public Tea(String name, String category, String country, String description){
        this(null, name, category, country, description, 0, 0);
    }

    public Tea(Integer id, String name, String category, String country, String description, int rate, int countConnoisseurs) {
        super(id, name);
        this.category = category;
        this.country = country;
        this.description = description;
        this.rate = rate;
        this.countConnoisseurs = countConnoisseurs;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getCountConnoisseurs() {
        return countConnoisseurs;
    }

    public void setCountConnoisseurs(int countConnoisseurs) {
        this.countConnoisseurs = countConnoisseurs;
    }

    @Override
    public String toString() {
        return "Tea{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", country='" + country + '\'' +
                ", description='" + description + '\'' +
                ", rate=" + rate +
                ", countConnoisseurs=" + countConnoisseurs +
                '}';
    }
}
