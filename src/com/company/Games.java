package com.company;

import java.io.Serializable;

public class Games implements Methods, Serializable {



    private String name;
    Genre genre;
    Consoles console;


    public Games(String name, Genre genre, Consoles console) {
        this.name = name;
        this.genre = genre;
        this.console = console;
    }
    @Override
    public String getName() {
        return name;
    }

    public Consoles getConsole() {
        return console;
    }




    public Genre getGenre() {
        return genre;
    }


}
