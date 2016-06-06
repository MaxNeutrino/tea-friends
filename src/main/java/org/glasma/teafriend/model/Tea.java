package org.glasma.teafriend.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = Tea.DELETE, query = "DELETE FROM Tea t WHERE t.id=:id"),
        @NamedQuery(name = Tea.BY_CATEGORY, query = "SELECT t FROM Tea t WHERE t.category=?1"),
        @NamedQuery(name = Tea.BY_COUNTRY, query = "SELECT t FROM Tea t WHERE t.country=?1"),
        @NamedQuery(name = Tea.ALL_SORTED, query = "SELECT t FROM Tea t ORDER BY t.name"),
})
@Entity
@Table(name = "tea")
public class Tea extends NamedEntity {

    public static final String DELETE = "Tea.delete";
    public static final String ALL_SORTED = "Tea.getAllSorted";
    public static final String BY_CATEGORY = "Tea.getByCategory";
    public static final String BY_COUNTRY = "Tea.getByCountry";

    @Column(name = "category")
    @NotEmpty
    protected String category;

    @Column(name = "country")
    @NotEmpty
    protected String country;

    @Column(name = "description")
    @NotEmpty
    protected String description;

    @Column(name = "rate")
    protected int rate;

    @Column(name = "count_connoisseurs")
    protected int countConnoisseurs;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "drunkTeaList")
    private List<User> userDrunk;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "wishTeaList")
    private List<User> userWish;

    public Tea(){}

    public Tea(Tea t) {
        this(t.getId(), t.getName(), t.getCategory(),
                t.getCountry(), t.getDescription(), t.getRate(), t.getCountConnoisseurs());
    }

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
                "id=" + id + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", country='" + country + '\'' +
                ", description='" + description + '\'' +
                ", rate=" + rate + '\'' +
                ", countConnoisseurs=" + countConnoisseurs + '\'' +
                '}';
    }
}
