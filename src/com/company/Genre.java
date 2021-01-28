package com.company;

import java.io.Serializable;

public class Genre implements Methods, Serializable {




    String name;


    public Genre(String genreName) {
        this.name = genreName;
    }


    @Override
    public String getName() {
        return name;
    }
}
