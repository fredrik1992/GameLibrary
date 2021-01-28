package com.company;

import java.io.Serializable;

public class Consoles implements Methods, Serializable {




    String name;
    String yearCreated;
    String company;



    public Consoles(String consoleName, String yearCreated, String company) {
        this.name = consoleName;
        this.yearCreated = yearCreated;
        this.company = company;
    }


    @Override
    public String getName() {
        return name;
    }

    public String getYearCreated() {
        return yearCreated;
    }

    public String getCompany() {
        return company;
    }


}
