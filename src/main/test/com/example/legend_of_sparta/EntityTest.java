package com.example.legend_of_sparta;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
//Author Allen Lam
class EntityTest {
    @Test
            void getX() {
        Entity entity = new Entity();
        entity.setPosition(30,30);
        assertEquals(30,entity.getX());
    }
}