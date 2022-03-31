package agh.ii.prinjava.proj2;

import agh.ii.prinjava.proj2.model.Movie;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class PlayWithMoviesTest {

    /**
     * The movies (only titles) directed (or co-directed) by a given director
     */
    @Test
    public void testEx01() {
        assertThat(PlayWithMovies.ex01("Guy Ritchie"))
                .containsExactlyInAnyOrder("Snatch", "Lock, Stock and Two Smoking Barrels");

        assertThat(PlayWithMovies.ex01("Christopher Nolan"))
                .containsExactlyInAnyOrder("The Dark Knight", "Inception", "Interstellar",
                        "The Prestige", "Memento", "The Dark Knight Rises", "Batman Begins");

        assertThat(PlayWithMovies.ex01("Quentin Tarantino"))
                .containsExactlyInAnyOrder("Pulp Fiction", "Django Unchained", "Reservoir Dogs",
                        "Inglourious Basterds", "Kill Bill: Vol. 1", "Sin City");
    }

    /**
     * The movies (only titles) in which an actor played
     */
    @Test
    public void testEx02() {
        assertThat(PlayWithMovies.ex02("Tom Hanks"))
                .containsExactlyInAnyOrder("Forrest Gump", "Saving Private Ryan", "The Green Mile",
                        "Toy Story 3", "Toy Story", "Catch Me If You Can");

        assertThat(PlayWithMovies.ex02("Tom Hardy"))
                .containsExactlyInAnyOrder("Inception", "The Dark Knight Rises",
                        "Warrior", "Mad Max: Fury Road", "The Revenant");

        assertThat(PlayWithMovies.ex02("Robert De Niro"))
                .containsExactlyInAnyOrder("The Godfather: Part II", "Goodfellas", "Once Upon a Time in America",
                        "Raging Bull", "Heat", "Casino", "The Deer Hunter");
    }

    /**
     * The number of movies per director (as a map)
     */
    @Test
    public void testEx03() {
        Map<String, Long> numOfMoviesPerDirector = PlayWithMovies.ex03();
        assertThat(numOfMoviesPerDirector.size()).isEqualTo(167);
        assertThat(numOfMoviesPerDirector).containsAllEntriesOf(Map.of(
                "Tim Burton", 1L,
                "Guy Ritchie", 2L,
                "Wes Anderson", 1L,
                "Christopher Nolan", 7L,
                "Quentin Tarantino", 6L,
                "Alfred Hitchcock", 9L));
    }

    /**
     * The 10 directors with the most films on the list
     */
    @Test
    public void testEx04() {
        Map<String, Long> tenMostFreqDirectors = PlayWithMovies.ex04();
        assertThat(tenMostFreqDirectors).containsAllEntriesOf(Map.of(
                "Alfred Hitchcock", 9L,
                "Stanley Kubrick", 8L,
                "Martin Scorsese", 7L,
                "Steven Spielberg", 7L,
                "Christopher Nolan", 7L,
                "Billy Wilder", 7L,
                "Quentin Tarantino", 6L,
                "Charles Chaplin", 5L,
                "Ridley Scott", 4L,
                "Frank Capra", 4L));
    }

    /**
     * The movies (only titles) made by each of the 10 directors found in {@link PlayWithMovies#ex04 ex04}
     */
    @Test
    public void testEx05() {
        Map<String, Set<String>> moviesPerDirector = PlayWithMovies.ex05();

        assertThat(moviesPerDirector.keySet()).containsExactlyInAnyOrder(
                "Alfred Hitchcock", "Stanley Kubrick", "Martin Scorsese", "Steven Spielberg",
                "Christopher Nolan", "Billy Wilder", "Quentin Tarantino", "Charles Chaplin",
                "Ridley Scott", "Frank Capra");

        assertThat(moviesPerDirector.get("Christopher Nolan")).containsExactlyInAnyOrder(
                "The Dark Knight", "Inception", "Interstellar", "The Prestige", "Memento",
                "The Dark Knight Rises", "Batman Begins"
        );

        assertThat(moviesPerDirector.get("Quentin Tarantino")).containsExactlyInAnyOrder(
                "Pulp Fiction", "Django Unchained", "Reservoir Dogs", "Inglourious Basterds",
                "Kill Bill: Vol. 1", "Sin City"
        );

        assertThat(moviesPerDirector.get("Ridley Scott")).containsExactlyInAnyOrder(
                "Gladiator", "Alien", "Blade Runner", "The Martian"
        );
    }

    /**
     * The number of movies per actor (as a map)
     */
    @Test
    public void testEx06() {
        Map<String, Long> numOfMoviesPerActor = PlayWithMovies.ex06();

        assertThat(numOfMoviesPerActor.size()).isEqualTo(773);
        assertThat(numOfMoviesPerActor).containsAllEntriesOf(Map.of(
                "Tom Hardy", 5L,
                "Derek Jacobi", 1L));
    }

    /**
     * The 9 actors with the most films on the list
     */
    @Test
    public void testEx07() {
        Map<String, Long> nineMostFreqActors = PlayWithMovies.ex07();

        assertThat(nineMostFreqActors).containsAllEntriesOf(Map.of(
                "Leonardo DiCaprio", 8L,
                "Harrison Ford", 7L,
                "James Stewart", 7L,
                "Robert De Niro", 7L,
                "Tom Hanks", 6L,
                "William Holden", 5L,
                "Paul Newman", 5L,
                "Tom Hardy", 5L,
                "Cary Grant", 5L));
    }

    /**
     * The movies (only titles) of each of the 9 actors from {@link PlayWithMovies#ex07 ex07}
     */
    @Test
    public void testEx08() {
        Map<String, Set<String>> moviesPerActor = PlayWithMovies.ex08();

        assertThat(moviesPerActor.keySet()).containsExactlyInAnyOrder(
                "Leonardo DiCaprio", "Harrison Ford", "James Stewart", "Robert De Niro",
                "Tom Hanks", "William Holden", "Paul Newman", "Tom Hardy", "Cary Grant");

        assertThat(moviesPerActor.get("Leonardo DiCaprio")).containsExactlyInAnyOrder(
                "Inception", "The Departed", "Django Unchained", "The Wolf of Wall Street",
                "Shutter Island", "Catch Me If You Can", "Blood Diamond", "The Revenant");

        assertThat(moviesPerActor.get("Tom Hanks")).containsExactlyInAnyOrder(
                "Forrest Gump", "Saving Private Ryan", "The Green Mile", "Toy Story 3",
                "Toy Story", "Catch Me If You Can");

        assertThat(moviesPerActor.get("Tom Hardy")).containsExactlyInAnyOrder(
                "Inception", "The Dark Knight Rises", "Warrior", "Mad Max: Fury Road",
                "The Revenant");
    }

    /**
     * The 5 most frequent actor partnerships (i.e., appearing together most often)
     */
    @Test
    public void testEx09() {
        Map<String, Long> fiveMostFreqActorDuos = PlayWithMovies.ex09();

        assertThat(fiveMostFreqActorDuos).containsAllEntriesOf(Map.of(
                "Carrie Fisher, Mark Hamill", 4L,
                "Joe Pesci, Robert De Niro", 4L,
                "Carrie Fisher, Harrison Ford", 4L,
                "Harrison Ford, Mark Hamill", 4L,
                "Christian Bale, Michael Caine", 3L));
    }

    /**
     * The movies (only titles) of each of the 5 most frequent actor partnerships
     */
    @Test
    public void testEx10() {
        Map<String, Set<String>> moviesPerActorDuo = PlayWithMovies.ex10();

        assertThat(moviesPerActorDuo.keySet()).containsExactlyInAnyOrder(
                "Carrie Fisher, Mark Hamill",
                "Joe Pesci, Robert De Niro",
                "Carrie Fisher, Harrison Ford",
                "Harrison Ford, Mark Hamill",
                "Christian Bale, Michael Caine");

        assertThat(moviesPerActorDuo.get("Carrie Fisher, Mark Hamill")).containsExactlyInAnyOrder(
                "Star Wars: Episode V - The Empire Strikes Back",
                "Star Wars: Episode IV - A New Hope",
                "Star Wars: Episode VI - Return of the Jedi",
                "Star Wars: The Force Awakens");

        assertThat(moviesPerActorDuo.get("Joe Pesci, Robert De Niro")).containsExactlyInAnyOrder(
                "Goodfellas", "Once Upon a Time in America", "Raging Bull", "Casino");

        assertThat(moviesPerActorDuo.get("Christian Bale, Michael Caine")).containsExactlyInAnyOrder(
                "The Dark Knight", "The Prestige", "Batman Begins");
    }
}
