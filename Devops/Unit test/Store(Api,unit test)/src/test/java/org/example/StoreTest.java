package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {
    Store s = new Store();
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void add() {
        int exp =1 ;
        int actual= s.add("chair",10);
        assertEquals(exp,actual);
    }

    @Test
    void remove() {
        int exp =1 ;
        int actual= s.remove("chair",10);
        assertEquals(exp,actual);
    }
}