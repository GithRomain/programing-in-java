package agh.ii.prinjava.proj2;

import agh.ii.prinjava.proj2.model.Movie;
import agh.ii.prinjava.proj2.dal.ImdbTop250;
import agh.ii.prinjava.proj2.utils.Utils;

import java.util.*;
import java.util.stream.Collectors;

interface PlayWithMovies{
    final Optional<List<Movie>> optMovies = ImdbTop250.movies();
    /**
     * Returns the movies (only titles) directed (or co-directed) by a given director
     */
    static Set<String> ex01(String director) {
        final Set<String> stringSet = optMovies.orElseThrow().stream()
                .filter(m -> m.directors().contains(director))
                .map(Movie::title)
                .collect(Collectors.toSet());
//        optMovies.orElseThrow().stream().map(m -> Utils.oneToManyByActor(m)).forEach(m -> System.out.println("///" + m));
        return stringSet;
    }

    /**
     * Returns the movies (only titles) in which an actor played
     */
    static Set<String> ex02(String actor) {
        final Set<String> stringSet = optMovies.orElseThrow().stream()
                .filter(m -> m.actors().contains(actor))
                .map(Movie::title)
                .collect(Collectors.toSet());
        return stringSet;
    }

    /**
     * Returns the movies (only titles) in which a duoactor played
     */
    static Set<String> ex02Bis(String duoActors, Optional<List<Movie>> optMovies) {
        final Set<String> stringSet = optMovies.orElseThrow().stream()
                .filter(m -> m.actors().contains(duoActors))
                .map(Movie::title)
                .collect(Collectors.toSet());
        return stringSet;
    }

    /**
     * Returns the number of movies per director (as a map)
     */
    static Map<String, Long> ex03() {
        final List<String> stringList = optMovies.orElseThrow().stream()
                .flatMap(m -> m.directors().stream())
                .collect(Collectors.toList());
        final Map<String, Long> stringLongMap = stringList.stream()
                .collect(Collectors.groupingBy(
                        String::valueOf,
                        Collectors.counting()
                        )
                );
        return stringLongMap;
    }

    /**
     * Returns the 10 directors with the most films on the list
     */
    static Map<String, Long> ex04() {
        final List<Long> longList = ex03().entrySet().stream()
                .map(sle -> sle.getValue())
                .sorted(Comparator.reverseOrder())
                .limit(10)
                .collect(Collectors.toList());
        final Map<String, Long> stringLongMap = ex03().entrySet().stream()
                .filter(sle -> longList.contains(sle.getValue()))
                .collect(Collectors.toMap(s -> s.getKey(), l -> l.getValue()));
        return stringLongMap;
    }

    /**
     * Returns the movies (only titles) made by each of the 10 directors found in {@link PlayWithMovies#ex04 ex04}
     */
    static Map<String, Set<String>> ex05() {
        final List<String> stringList = ex04().entrySet().stream()
                .map(sle -> sle.getKey())
                .collect(Collectors.toList());
        final Map<String, Set<String>> stringSetMap = stringList.stream()
                .collect(Collectors.toMap(sl -> sl, sl -> ex01(sl)));
        return stringSetMap;
    }

    /**
     * Returns the number of movies per actor (as a map)
     */
    static Map<String, Long> ex06() {
        final List<String> stringList = optMovies.orElseThrow().stream()
                .flatMap(m -> m.actors().stream())
                .collect(Collectors.toList());
        final Map<String, Long> stringLongMap = stringList.stream()
                .collect(Collectors.groupingBy(
                                String::valueOf,
                                Collectors.counting()
                        )
                );
        return stringLongMap;
    }

    /**
     * Returns the number of movies per actor of an introduced Movie List
     */
    static Map<String, Long> ex06Bis(Optional<List<Movie>> optMovies) {
        final List<String> stringList = optMovies.orElseThrow().stream()
                .flatMap(m -> m.actors().stream())
                .collect(Collectors.toList());
        final Map<String, Long> stringLongMap = stringList.stream()
                .collect(Collectors.groupingBy(
                                String::valueOf,
                                Collectors.counting()
                        )
                );
        return stringLongMap;
    }

    /**
     * Returns the 9 actors with the most films on the list
     */
    static Map<String, Long> ex07() {
        final List<Long> longList = ex06().entrySet().stream()
                .map(sle -> sle.getValue())
                .sorted(Comparator.reverseOrder())
                .limit(9)
                .collect(Collectors.toList());
        final Map<String, Long> stringLongMap = ex06().entrySet().stream()
                .filter(sle -> longList.contains(sle.getValue()))
                .collect(Collectors.toMap(s -> s.getKey(), l -> l.getValue()));
        return stringLongMap;
    }

    /**
     * Returns the 5 duactors with the most films together on the list
     */
    static Map<String, Long> ex07Bis(Optional<List<Movie>> optMovies) {
        final List<Long> longList = ex06Bis(optMovies).entrySet().stream()
                .map(sle -> sle.getValue())
                .sorted(Comparator.reverseOrder())
                .limit(5)
                .collect(Collectors.toList());
        final Map<String, Long> stringLongMap = ex06Bis(optMovies).entrySet().stream()
                .filter(sle -> longList.contains(sle.getValue()))
                .collect(Collectors.toMap(s -> s.getKey(), l -> l.getValue()));
        return stringLongMap;
    }

    /**
     * Returns the movies (only titles) of each of the 9 actors from {@link PlayWithMovies#ex07 ex07}
     */
    static Map<String, Set<String>> ex08() {
        final List<String> stringList = ex07().entrySet().stream()
                .map(sle -> sle.getKey())
                .collect(Collectors.toList());
        final Map<String, Set<String>> stringSetMap = stringList.stream()
                .collect(Collectors.toMap(sl -> sl, sl -> ex02(sl)));
        return stringSetMap;
    }

    /**
     * Returns the 5 most frequent actor partnerships (i.e., appearing together most often)
     */
    static Map<String, Long> ex09() {
        final List<Movie> movieList = optMovies.orElseThrow().stream()
                .flatMap(m -> Utils.oneToManyByActorDuo(m).stream())
                .collect(Collectors.toList());
        final Map<String, Long> stringLongMap = ex07Bis(Optional.of(movieList));
        return stringLongMap;
    }

    /**
     * Returns the movies (only titles) of each of the 5 most frequent actor partnerships
     */
    static Map<String, Set<String>> ex10() {
        final List<Movie> movieList = optMovies.orElseThrow().stream()
                .flatMap(m -> Utils.oneToManyByActorDuo(m).stream())
                .collect(Collectors.toList());

        final List<String> stringList = ex09().entrySet().stream()
                .map(sle -> sle.getKey())
                .collect(Collectors.toList());

        final Map<String, Set<String>> stringSetMap = stringList.stream()
                .collect(Collectors.toMap(sl -> sl, sl -> ex02Bis(sl, Optional.of(movieList))));
        return stringSetMap;
    }
}

