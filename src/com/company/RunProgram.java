package com.company;

import java.text.BreakIterator;
import java.util.HashMap;
import java.util.List;
import  java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class RunProgram {
    HashMap <String,Consoles> consoles;
    HashMap <String,Games> games;
    HashMap <String,Genre> genres;

    private static final int GAMES_IN_CONSOLE = 1;
    private static final int GAMES_IN_GENRE = 2;
    private static final int ADD_NEW_GAME = 3;
    private static final int REMOVE_GAME = 4;
    private static final int SAVE_DATA = 5;

    public RunProgram() {
        genres = (HashMap<String, Genre>) HandelData.readObject("Genres.ser");
        games = (HashMap<String, Games>) HandelData.readObject("Games.ser");
        consoles = (HashMap<String, Consoles>) HandelData.readObject("Consoles.ser");
    }

    public  void run(){


        Scanner input = new Scanner(System.in);
        int choice =0;
        while(choice !=5){
            System.out.println("write 1 to see all games belonging to a specific console, 2 to see all games in the same genre,3 to add game ,4 to remove game,5 to quit " );
             choice = input.nextInt();
             switch (choice){
                 case GAMES_IN_CONSOLE:
                     checkGamesBelongingToConsole(games);
                     break;

                 case GAMES_IN_GENRE:
                     checkAfterGamesBelongingToGenre(genres,games);

                 case ADD_NEW_GAME:
                     Games gameToAdd =addGame(consoles,genres);
                     games.put(gameToAdd.getName(),gameToAdd);
                     break;
                 case REMOVE_GAME:
                     removeGame(games);
                     break;


                 case SAVE_DATA:
                     HandelData.writeData(consoles,"Consoles.ser");
                     HandelData.writeData(games,"Games.ser");
                     HandelData.writeData(genres,"Genres.ser");
                     break;
             }


        }
    }
    public  void checkGamesBelongingToConsole(HashMap<String,Games> games){
        Scanner input = new Scanner(System.in);
        System.out.println("specify wich console to check for games");
        String consoleName= input.nextLine();

        games.values()
        .stream()
        .filter(game -> game.getConsole().getName().equals(consoleName))
                .forEach(game ->System.out.println(game.getName()));


    }

    public  void checkAfterGamesBelongingToGenre(HashMap<String,Genre> genres,HashMap<String,Games> games){
        Scanner input = new Scanner(System.in);

        System.out.println("specify wich genre to check for games");
        String genreName= input.nextLine();

        games.values()
                .stream()
                .filter(game -> game.getGenre().getName().equals(genreName))
                .forEach(game ->System.out.println(game.getName()));


    }

    public  Games addGame(HashMap <String,Consoles> consoles,HashMap <String,Genre> genre){
        Scanner input = new Scanner(System.in);

        String addName;
        String addGenre;
        String addConsole;
        List<Genre> tempGenre;
        List<Consoles> tempConsole;

        System.out.println("please write the name of the game");
        addName = input.next();

        System.out.println("please write the name of the genre from this list");

        printAllHasValues(genre);
        addGenre= input.next();

        tempGenre =genre.values()
                .stream()
                .filter(genreItem -> genreItem.getName().equals(addGenre))
                .collect(Collectors.toList());


        System.out.println("please write the name of the console from this list");
        printAllHasValues(consoles);

        addConsole = input.next();

        tempConsole =consoles.values()
                .stream()
                .filter(consoleItem -> consoleItem.getName().equals(addConsole))
                .collect(Collectors.toList());


        Games game = new Games(addName,tempGenre.get(0),tempConsole.get(0));
        return game;







    }
    public   <T extends Methods>  void printAllHasValues    ( HashMap<String,T> hashMap  ){

        hashMap.values()
                .stream()
                .forEach(item -> System.out.println(item.getName()));

    }
    public  void removeGame(HashMap<String,Games> games){

        Scanner input = new Scanner(System.in);

        String removeGame;
        System.out.println("write the name of the game from the list to remove");

        printAllHasValues(games);
        removeGame = input.next();
        games.remove(removeGame);

    }
}
