package agh.ii.prinjava.lab09.exc09_01.dal;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class MovieDAOTest {

    private static final String dbURL = "jdbc:sqlite:datasources/imdb_top250.db";
    MovieDAO movieDAO = new MovieDAO(dbURL);

    @Test
    void moviesDirectedBy() {
        assertThat(movieDAO.moviesDirectedBy("Christopher Nolan").orElseThrow())
                .containsExactlyInAnyOrder("The Dark Knight", "Inception", "Interstellar",
                        "The Prestige", "Memento", "The Dark Knight Rises", "Batman Begins");

        assertThat(movieDAO.moviesDirectedBy("Guy Ritchie").orElseThrow())
                .containsExactlyInAnyOrder("Snatch", "Lock, Stock and Two Smoking Barrels");

        assertThat(movieDAO.moviesDirectedBy("Quentin Tarantino").orElseThrow())
                .containsExactlyInAnyOrder("Pulp Fiction", "Django Unchained", "Reservoir Dogs",
                        "Inglourious Basterds", "Kill Bill: Vol. 1", "Sin City");
    }

    @Test
    void moviesTheActorPlayedIn() {
        //TODO complete the test of ex02
        throw new RuntimeException("ex02Test not implemented");
    }

    @Test
    void numberOfMoviesPerDirector() {
        //TODO complete the test of ex03
        throw new RuntimeException("ex03Test not implemented");
    }

    @Test
    void numberOfMoviesPerTop10Director() {
        //TODO complete the test of ex04
        throw new RuntimeException("ex04Test not implemented");
    }

    @Test
    void moviesPerTop10Director() {
        //TODO complete the test of ex05
        throw new RuntimeException("ex05Test not implemented");
    }

    @Test
    void numberOfMoviesPerActor() {
        //TODO complete the test of ex06
        throw new RuntimeException("ex06Test not implemented");
    }

    @Test
    void numberOfMoviesPerTop9Actor() {
        //TODO complete the test of ex07
        throw new RuntimeException("ex07Test not implemented");
    }

    @Test
    void moviesPerTop9Actor() {
        //TODO complete the test of ex08
        throw new RuntimeException("ex08Test not implemented");
    }

    @Test
    void top5FrequentActorPartnerships() {
        //TODO complete the test of ex09
        throw new RuntimeException("ex09Test not implemented");
    }

    @Test
    void moviesPerTop5ActorPartnerships() {
        //TODO complete the test of ex10
        throw new RuntimeException("ex10Test not implemented");
    }
}