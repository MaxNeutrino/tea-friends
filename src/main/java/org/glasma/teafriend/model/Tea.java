package org.glasma.teafriend.model;

public class Tea extends NamedEntity{

    private String category;

    private String country;

    private String description;

    private int rate;

    private int countConnoisseurs;

    public Tea(){}

    public Tea(Integer id, String name, String category, String country, String description) {
        super(id, name);
        this.category = category;
        this.country = country;
        this.description = description;
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
