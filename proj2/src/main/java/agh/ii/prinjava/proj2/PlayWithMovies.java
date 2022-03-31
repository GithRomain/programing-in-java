package agh.ii.prinjava.proj2;

import agh.ii.prinjava.proj2.model.Movie;
import agh.ii.prinjava.proj2.dal.ImdbTop250;

import java.util.*;
import java.util.stream.Collectors;

interface PlayWithMovies {

    /**
     * Returns the movies (only titles) directed (or co-directed) by a given director
     */
    static Set<String> ex01(String director) {
        final Optional<List<Movie>> optMovies = ImdbTop250.movies();
        final Set<String> stringSet = optMovies.orElseThrow().stream()
                .filter(m -> m.directors().contains(director))
                .map(Movie::title)
                .collect(Collectors.toSet());
        return stringSet;
    }

    /**
     * Returns the movies (only titles) in which an actor played
     */
    static Set<String> ex02(String actor) {
        final Optional<List<Movie>> optMovies = ImdbTop250.movies();
        final Set<String> stringSet = optMovies.orElseThrow().stream()
                .filter(m -> m.actors().contains(actor))
                .map(Movie::title)
                .collect(Collectors.toSet());
        return stringSet;
    }

    /**
     * Returns the number of movies per director (as a map)
     */
    static Map<String, Long> ex03() {
        final Optional<List<Movie>> optMovies = ImdbTop250.movies();
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
        final Optional<List<Movie>> optMovies = ImdbTop250.movies();
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
    static void ex09() {
        final Optional<List<Movie>> optMovies = ImdbTop250.movies();
        final List<String> stringList = optMovies.orElseThrow().stream()
                .map(m -> m.actors().toString())
                .collect(Collectors.toList());
        System.out.println(stringList);
        final List<String> stringList1 = stringList.stream()
                .skip(2)
                .collect(Collectors.toList());
        System.out.println(stringList1);
    }

    /**
     * Returns the movies (only titles) of each of the 5 most frequent actor partnerships
     */
    static Map<String, Set<String>> ex10() {
        throw new RuntimeException("ex10 is not implemented!");
    }
}

