package agh.ii.prinjava.proj2;

import agh.ii.prinjava.proj2.model.Movie;
import agh.ii.prinjava.proj2.dal.ImdbTop250;
import agh.ii.prinjava.proj2.utils.Utils;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

interface PlayWithMovies{
    Optional<List<Movie>> optMovies = ImdbTop250.movies();
    List<Movie> optMoviesByDirector = optMovies.orElseThrow().stream()
            .flatMap(m -> Utils.oneToManyByDirector(m).stream())
            .collect(Collectors.toList());
    List<Movie> optMoviesByActor = optMovies.orElseThrow().stream()
            .flatMap(m -> Utils.oneToManyByActor(m).stream())
            .collect(Collectors.toList());
    List<Movie> optMoviesByActorDuo = optMovies.orElseThrow().stream()
            .flatMap(m -> Utils.oneToManyByActorDuo(m).stream())
            .collect(Collectors.toList());

    Map<String, Long> mapNumberOfMoviesPerDirector = ex03();
    Map<String, Long> map10DirectorsWithMostFilms = ex04();
    Map<String, Long> mapNumberOfMoviesPerActor = ex06();
    Map<String, Long> mapNumberOfMoviesPerActorDuo = ex06Bis();
    Map<String, Long> map9ActorsWithMostFilms = ex07();

    Map<String, Long> map5ActorsDuoWithMostFilms = ex09();

    /**
     * Returns the movies (only titles) directed (or co-directed) by a given director
     */
    static Set<String> ex01(String director) {
        final Set<String> setTitlesMoviesByDirector = optMoviesByDirector.stream()
                .filter(m -> m.directors().contains(director))
                .map(Movie::title)
                .collect(Collectors.toSet());
        return setTitlesMoviesByDirector;
    }

    /**
     * Returns the movies (only titles) in which an actor played
     */
    static Set<String> ex02(String actor) {
        final Set<String> setTitlesMoviesByActor = optMoviesByActor.stream()
                .filter(m -> m.actors().contains(actor))
                .map(Movie::title)
                .collect(Collectors.toSet());
        return setTitlesMoviesByActor;
    }

    /**
     * Returns the movies (only titles) in which a duoactor played
     */
    static Set<String> ex02Bis(String duoActors) {
        final Set<String> setTitlesMoviesByActorDuo = optMoviesByActorDuo.stream()
                .filter(m -> m.actors().contains(duoActors))
                .map(Movie::title)
                .collect(Collectors.toSet());
        return setTitlesMoviesByActorDuo;
    }

    /**
     * Returns the number of movies per director (as a map)
     */
    static Map<String, Long> ex03() {
        final List<String> listStringOfDirectors = optMoviesByDirector.stream()
                .flatMap(m -> m.directors().stream())
                .collect(Collectors.toList());
        final Map<String, Long> mapNumberOfMoviesPerDirector = listStringOfDirectors.stream()
                .collect(Collectors.groupingBy(
                                s -> s,
                                Collectors.counting()
                        )
                );
        return mapNumberOfMoviesPerDirector;
    }

    /**
     * Returns the 10 directors with the most films on the list
     */
    static Map<String, Long> ex04() {
        final List<Long> listNumberOfMoviePerDirector = mapNumberOfMoviesPerDirector.entrySet().stream()
                .map(sl -> sl.getValue())
                .sorted(Comparator.reverseOrder())
                .limit(10)
                .collect(Collectors.toList());
        final Map<String, Long> map10DirectorsWithMostFilms = mapNumberOfMoviesPerDirector.entrySet().stream()
                .filter(sl -> listNumberOfMoviePerDirector.contains(sl.getValue()))
                .collect(Collectors.toMap(s -> s.getKey(), l -> l.getValue()));
        return map10DirectorsWithMostFilms;
    }

    /**
     * Returns the movies (only titles) made by each of the 10 directors found in {@link PlayWithMovies#ex04 ex04}
     */
    static Map<String, Set<String>> ex05() {
        final List<String> list10DirectorsWithMostFilms = map10DirectorsWithMostFilms.entrySet().stream()
                .map(sl -> sl.getKey())
                .collect(Collectors.toList());
        final Map<String, Set<String>> mapMoviesTitlesBy10DirectorsWithMostFilms = list10DirectorsWithMostFilms.stream()
                .collect(Collectors.toMap(sl -> sl, sl -> ex01(sl)));
        return mapMoviesTitlesBy10DirectorsWithMostFilms;
    }

    /**
     * Returns the number of movies per actor (as a map)
     */
    static Map<String, Long> ex06() {
        final List<String> listStringOfActors = optMoviesByActor.stream()
                .flatMap(m -> m.actors().stream())
                .collect(Collectors.toList());
        final Map<String, Long> mapNumberOfMoviesPerActor = listStringOfActors.stream()
                .collect(Collectors.groupingBy(
                                String::valueOf,
                                Collectors.counting()
                        )
                );
        return mapNumberOfMoviesPerActor;
    }

    /**
     * Returns the number of movies per actorDuo (as a map)
     */
    static Map<String, Long> ex06Bis() {
        final List<String> listStringOfActorsDuo = optMoviesByActorDuo.stream()
                .flatMap(m -> m.actors().stream())
                .collect(Collectors.toList());
        final Map<String, Long> mapNumberOfMoviesPerActorDuo = listStringOfActorsDuo.stream()
                .collect(Collectors.groupingBy(
                                String::valueOf,
                                Collectors.counting()
                        )
                );
        return mapNumberOfMoviesPerActorDuo;
    }

    /**
     * Returns the 9 actors with the most films on the list
     */
    static Map<String, Long> ex07() {
        final List<Long> listNumberOfMoviePerActor = mapNumberOfMoviesPerActor.entrySet().stream()
                .map(sl -> sl.getValue())
                .sorted(Comparator.reverseOrder())
                .limit(9)
                .collect(Collectors.toList());
        final Map<String, Long> map9ActorsWithMostFilms = mapNumberOfMoviesPerActor.entrySet().stream()
                .filter(sl -> listNumberOfMoviePerActor.contains(sl.getValue()))
                .collect(Collectors.toMap(s -> s.getKey(), l -> l.getValue()));
        return map9ActorsWithMostFilms;
    }

    /**
     * Returns the 5 duactors with the most films together on the list
     */
    static Map<String, Long> ex07Bis() {
        final List<Long> longList =mapNumberOfMoviesPerActorDuo.entrySet().stream()
                .map(sl -> sl.getValue())
                .sorted(Comparator.reverseOrder())
                .limit(5)
                .collect(Collectors.toList());
        final Map<String, Long> map5ActorsDuoWithMostFilms = ex06Bis().entrySet().stream()
                .filter(sl -> longList.contains(sl.getValue()))
                .collect(Collectors.toMap(s -> s.getKey(), l -> l.getValue()));
        return map5ActorsDuoWithMostFilms;
    }

    /**
     * Returns the movies (only titles) of each of the 9 actors from {@link PlayWithMovies#ex07 ex07}
     */
    static Map<String, Set<String>> ex08() {
        final List<String> list9ActorsWithMostFilms = map9ActorsWithMostFilms.entrySet().stream()
                .map(sl -> sl.getKey())
                .collect(Collectors.toList());
        final Map<String, Set<String>> mapMoviesTitlesBy9ActorsWithMostFilms = list9ActorsWithMostFilms.stream()
                .collect(Collectors.toMap(sl -> sl, sl -> ex02(sl)));
        return mapMoviesTitlesBy9ActorsWithMostFilms;
    }

    /**
     * Returns the 5 most frequent actor partnerships (i.e., appearing together most often)
     */
    static Map<String, Long> ex09() {
        final Map<String, Long> map5ActorsDuoWithMostFilms = ex07Bis();
        return map5ActorsDuoWithMostFilms;
    }

    /**
     * Returns the movies (only titles) of each of the 5 most frequent actor partnerships
     */
    static Map<String, Set<String>> ex10() {
        final List<String> listStringOfActorsDuo = map5ActorsDuoWithMostFilms.entrySet().stream()
                .map(sle -> sle.getKey())
                .collect(Collectors.toList());

        final Map<String, Set<String>> mapMoviesTitlesBy5ActorsDuoWithMostFilms = listStringOfActorsDuo.stream()
                .collect(Collectors.toMap(sl -> sl, sl -> ex02Bis(sl)));
        return mapMoviesTitlesBy5ActorsDuoWithMostFilms;
    }
}
