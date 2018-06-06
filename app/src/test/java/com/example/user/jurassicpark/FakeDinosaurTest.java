package com.example.user.jurassicpark;

import com.example.user.jurassicpark.MockTestable.FakeDinosaur;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FakeDinosaurTest {
    FakeDinosaur dinosaur, dinosaur2;

    @Before
    public void before(){
        dinosaur = new FakeDinosaur(8);
        dinosaur2 = new FakeDinosaur(-3);
    }


    @Test
    public void canGetHungerLevel() {
        assertEquals(8, dinosaur.getHungerLevel());
    }

    @Test
    public void hungerLevelCannotBeLessThanZero() {
        assertEquals(0, dinosaur2.getHungerLevel());
    }

    @Test
    public void canRampage() {
        assertEquals(true, dinosaur.rampage());
    }

    @Test
    public void willNotRampageUnlessHungry() {
        assertEquals(false, dinosaur2.rampage());
    }


}
