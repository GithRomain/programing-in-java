package agh.ii.prinjava.lab09.exc09_01;

import agh.ii.prinjava.lab09.exc09_01.dal.MovieDAO;

public class PlayWithMovies {
    private static final String dbURL = "jdbc:sqlite:lab09/datasources/imdb_top250.db";

    private static void ex1() {
        System.out.println("ex1...");
        MovieDAO movieDAO = new MovieDAO(dbURL);
        var r = movieDAO.moviesDirectedBy("Christopher Nolan");
        System.out.println(r.orElseThrow());
    }

    private static void ex2() {
        System.out.println("\nex2...");
        MovieDAO movieDAO = new MovieDAO(dbURL);
        var r = movieDAO.moviesTheActorPlayedIn("Tom Hanks");
        System.out.println(r.orElseThrow());
    }

    private static void ex3() {
        System.out.println("\nex3...");
        MovieDAO movieDAO = new MovieDAO(dbURL);
        var r = movieDAO.numberOfMoviesPerDirector();
        r.ifPresent(m -> m.forEach((k, v) -> System.out.println(k + " => " + v)));
    }

    private static void ex4() {
        System.out.println("\nex4...");
        MovieDAO movieDAO = new MovieDAO(dbURL);
        var r = movieDAO.numberOfMoviesPerTop10Director();
        r.ifPresent(m -> m.forEach((k, v) -> System.out.println(k + " => " + v)));
    }

    private static void ex5() {
        System.out.println("\nex5...");
        MovieDAO movieDAO = new MovieDAO(dbURL);
        var r = movieDAO.moviesPerTop10Director();
        r.ifPresent(m -> m.forEach((k, v) -> System.out.println(k + " => " + v)));
    }

    private static void ex6() {
        System.out.println("\nex6...");
        MovieDAO movieDAO = new MovieDAO(dbURL);
        var r = movieDAO.numberOfMoviesPerActor();
        r.ifPresent(m -> m.forEach((k, v) -> System.out.println(k + " => " + v)));
    }

    private static void ex7() {
        System.out.println("\nex7...");
        MovieDAO movieDAO = new MovieDAO(dbURL);
        var r = movieDAO.numberOfMoviesPerTop9Actor();
        r.ifPresent(m -> m.forEach((k, v) -> System.out.println(k + " => " + v)));
    }

    private static void ex8() {
        System.out.println("\nex8...");
        MovieDAO movieDAO = new MovieDAO(dbURL);
        var r = movieDAO.moviesPerTop9Actor();
        r.ifPresent(m -> m.forEach((k, v) -> System.out.println(k + " => " + v)));
    }

    private static void ex9() {
        System.out.println("\nex9...");
        MovieDAO movieDAO = new MovieDAO(dbURL);
        var r = movieDAO.top5FrequentActorPartnerships();
        r.ifPresent(m -> m.forEach((k, v) -> System.out.println(k + " => " + v)));
    }

    private static void ex10() {
        System.out.println("\nex10...");
        MovieDAO movieDAO = new MovieDAO(dbURL);
        var r = movieDAO.moviesPerTop5ActorPartnerships();
        r.ifPresent(m -> m.forEach((k, v) -> System.out.println(k + " => " + v)));
    }

    public static void main(String[] args) {
        ex1();
        ex2();
        ex3();
        ex4();
        ex5();
        ex6();
        ex7();
        ex8();
        ex9();
        ex10();
    }
}
