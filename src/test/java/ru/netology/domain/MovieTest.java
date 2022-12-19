package ru.netology.domain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    @Test
    public void ShouldGetParams() {
        Movie item1 = new Movie("Бладшот", "боевик");
        Assertions.assertEquals("Бладшот", item1.getName());
        Assertions.assertEquals("боевик", item1.getGenre());
    }

}