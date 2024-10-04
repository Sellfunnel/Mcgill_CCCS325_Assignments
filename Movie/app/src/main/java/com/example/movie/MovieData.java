package com.example.movie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class MovieData {
    public static final Map<String, List<String>> MOVIES_BY_GENRE = new HashMap<>();

    static {
        MOVIES_BY_GENRE.put("Comedy", Arrays.asList("Superbad", "Step Brothers", "The Hangover"));
        MOVIES_BY_GENRE.put("Horror", Arrays.asList("The Conjuring", "Hereditary", "It Follows"));
        MOVIES_BY_GENRE.put("Romance", Arrays.asList("The Notebook", "Pride and Prejudice", "La La Land"));
    }
}
