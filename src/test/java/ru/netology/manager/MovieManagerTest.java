package ru.netology.manager;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {

    Movie item1 = new Movie("Бладшот", "боевик");
    Movie item2 = new Movie("Вперед", "мультфильм");
    Movie item3 = new Movie("Отель Белград", "комедия");
    Movie item4 = new Movie("Джентльмены", "боевик");
    Movie item5 = new Movie("Человек-невидимка", "ужасы");
    Movie item6 = new Movie("Тролли. Мировой тур", "мультфильм");
    Movie item7 = new Movie("Номер 1", "комедия");
    Movie item8 = new Movie("Человек-невидимка 2", "ужасы");
    Movie item9 = new Movie("Номер 2", "комедия");
    Movie item10 = new Movie("Оно", "боевик");
    Movie item11 = new Movie("Очень интересный фильм", "комедия");


    @Test
    public void shouldSave() {
        MovieManager manager = new MovieManager();
        manager.saveMovie(item1);
        manager.saveMovie(item2);
        manager.saveMovie(item3);
        Movie[] expected = {item1, item2, item3};
        Movie[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllIfOverlimit() {
        MovieManager manager = new MovieManager();
        manager.saveMovie(item1);
        manager.saveMovie(item2);
        manager.saveMovie(item3);
        manager.saveMovie(item4);
        manager.saveMovie(item5);
        manager.saveMovie(item6);
        manager.saveMovie(item7);
        manager.saveMovie(item8);
        manager.saveMovie(item9);
        manager.saveMovie(item10);
        manager.saveMovie(item11);
        Movie[] expected = {item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11};
        Movie[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastLimitNotSet10Items() {
        MovieManager manager = new MovieManager();
        manager.saveMovie(item1);
        manager.saveMovie(item2);
        manager.saveMovie(item3);
        manager.saveMovie(item4);
        manager.saveMovie(item5);
        manager.saveMovie(item6);
        manager.saveMovie(item7);
        manager.saveMovie(item8);
        manager.saveMovie(item9);
        manager.saveMovie(item10);
        Movie[] expected = {item10, item9, item8,item7, item6, item5, item4, item3, item2, item1};
        Movie[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastLimitNotSetLess10Items() {
        MovieManager manager = new MovieManager();
        manager.saveMovie(item1);
        manager.saveMovie(item2);
        manager.saveMovie(item3);
        manager.saveMovie(item4);
        manager.saveMovie(item5);
        manager.saveMovie(item6);
        Movie[] expected = {item6, item5, item4, item3, item2, item1};
        Movie[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastLimitNotSetMore10Items() {
        MovieManager manager = new MovieManager();
        manager.saveMovie(item1);
        manager.saveMovie(item2);
        manager.saveMovie(item3);
        manager.saveMovie(item4);
        manager.saveMovie(item5);
        manager.saveMovie(item6);
        manager.saveMovie(item7);
        manager.saveMovie(item8);
        manager.saveMovie(item9);
        manager.saveMovie(item10);
        manager.saveMovie(item11);
        Movie[] expected = {item11, item10, item9, item8,item7, item6, item5, item4, item3, item2};
        Movie[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastLimitSet10Items() {
        MovieManager manager = new MovieManager(5);
        manager.saveMovie(item1);
        manager.saveMovie(item2);
        manager.saveMovie(item3);
        manager.saveMovie(item4);
        manager.saveMovie(item5);
        manager.saveMovie(item6);
        manager.saveMovie(item7);
        manager.saveMovie(item8);
        manager.saveMovie(item9);
        manager.saveMovie(item10);
        Movie[] expected = {item10, item9, item8,item7, item6};
        Movie[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastLimitSetLess10Items() {
        MovieManager manager = new MovieManager(5);
        manager.saveMovie(item1);
        manager.saveMovie(item2);
        manager.saveMovie(item3);
        manager.saveMovie(item4);
        manager.saveMovie(item5);
        manager.saveMovie(item6);
        manager.saveMovie(item7);
        Movie[] expected = {item7, item6, item5,item4, item3};
        Movie[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastLimitNotSetMore10Items4() {
        MovieManager manager = new MovieManager(4);
        manager.saveMovie(item1);
        manager.saveMovie(item2);
        manager.saveMovie(item3);
        manager.saveMovie(item4);
        manager.saveMovie(item5);
        manager.saveMovie(item6);
        manager.saveMovie(item7);
        manager.saveMovie(item8);
        manager.saveMovie(item9);
        manager.saveMovie(item10);
        manager.saveMovie(item11);
        Movie[] expected = {item11, item10, item9, item8};
        Movie[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }






}