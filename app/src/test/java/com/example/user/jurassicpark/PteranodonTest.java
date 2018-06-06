package com.example.user.jurassicpark;

import com.example.user.jurassicpark.Dinosaurs.FeedType;
import com.example.user.jurassicpark.Dinosaurs.Pteranodon;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


import static org.junit.Assert.assertEquals;

public class PteranodonTest {
    Pteranodon pteranodon;

    @Before
    public void before() {
        pteranodon = new Pteranodon(FeedType.HERBIVORE, "Pteranodon", "Elvis");
    }

    @Test
    public void canGetFeedType() {
        assertEquals(FeedType.HERBIVORE, pteranodon.getFeedType());
    }

    @Test
    public void canGeType() {
        assertEquals("Pteranodon", pteranodon.getType());
    }

    @Test
    public void canGetName() {
        assertEquals("Elvis", pteranodon.getName());
    }

    @Test
    public void canGetRampagePower() {
        assertEquals(50, pteranodon.getRampagePower());
    }

    @Test
    public void canGetHungerLevel() {
        Pteranodon pteranodon1 = new Pteranodon(FeedType.HERBIVORE, "Pteranodon", "Mitchell");
        Pteranodon spyPteranodon = Mockito.spy(pteranodon1);

        Mockito.when(spyPteranodon.getHungerLevel()).thenReturn(8);
        assertEquals(8, spyPteranodon.getHungerLevel());
    }

    @Test
    public void canEat() {
        pteranodon.eat();
        assertEquals(1, pteranodon.getHungerLevel());
    }


    @Test
    public void canRampage() {
        Pteranodon pteranodon1 = new Pteranodon(FeedType.HERBIVORE, "Pteranodon", "Mitchell");
        Pteranodon spyPteranodon = Mockito.spy(pteranodon1);

        Mockito.when(spyPteranodon.getHungerLevel()).thenReturn(6);
        assertEquals(true, spyPteranodon.rampage());
    }

    @Test
    public void willNotRampageUnlessHungry(){
        Pteranodon pteranodon1 = new Pteranodon(FeedType.HERBIVORE, "Pteranodon", "Mitchell");
        Pteranodon spyPteranodon = Mockito.spy(pteranodon1);

        Mockito.when(spyPteranodon.getHungerLevel()).thenReturn(1);
        assertEquals(false, spyPteranodon.rampage());
    }

}
