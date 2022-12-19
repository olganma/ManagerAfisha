package ru.netology.manager;
import ru.netology.domain.Movie;

import java.util.Arrays;

public class MovieManager {

    private int limitLength = 10;

    public Movie[] items = new Movie[0];

    public void saveMovie(Movie item) {
        Movie tmp[] = new Movie[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];

        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public Movie[] findAll() {
        return items;
    }

    public MovieManager() {
        int limitLength = 10;
    }

    public MovieManager(int limitLength) {
        this.limitLength = limitLength;
    }

    public Movie[] findLast() {
        Movie all[] = findAll();
        int resultLength;
        if (items.length > limitLength) {
            resultLength = limitLength;
        } else {
            resultLength = all.length;
        }
        Movie result[] = new Movie[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = all[all.length - 1 - i];
        }
        return result;
    }


}
