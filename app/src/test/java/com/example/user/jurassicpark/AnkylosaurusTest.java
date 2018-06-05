package com.example.user.jurassicpark;

import com.example.user.jurassicpark.DinosaurBehaviour.IWalk;
import com.example.user.jurassicpark.Dinosaurs.Ankylosaurus;
import com.example.user.jurassicpark.Dinosaurs.FeedType;
import com.example.user.jurassicpark.Paddocks.CloudForest;
import com.example.user.jurassicpark.Paddocks.PaddockType;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AnkylosaurusTest {
    Ankylosaurus ankylosaurus;

    @Before
    public void before() {
        ankylosaurus = new Ankylosaurus(FeedType.HERBIVORE, "Ankylosaurus", "Stompy", 1);
    }

    @Test
    public void canGetFeedType() {
        assertEquals(FeedType.HERBIVORE, ankylosaurus.getFeedType());
    }

    @Test
    public void canGeType() {
        assertEquals("Ankylosaurus", ankylosaurus.getType());
    }

    @Test
    public void canGetName() {
        assertEquals("Stompy", ankylosaurus.getName());
    }

    @Test
    public void canGetHungerLevel() {
        assertEquals(1, ankylosaurus.getHungerLevel());
    }

    @Test
    public void hungerLevelCannotBeLessThanZero() {
        Ankylosaurus ankylosaurus2 = new Ankylosaurus(FeedType.HERBIVORE, "Ankylosaurus", "Debby", -2);
        assertEquals(0, ankylosaurus2.getHungerLevel());
    }

    @Test
    public void canGetRampagePower() {
        assertEquals(40, ankylosaurus.getRampagePower());
    }

    @Test
    public void canEat() {
        ankylosaurus.eat();
        assertEquals(1, ankylosaurus.getHungerLevel());
    }

    @Test
    public void canRampage() {
        Ankylosaurus ankylosaurus2 = new Ankylosaurus(FeedType.HERBIVORE, "Ankylosaurus", "Russel", 7);
        assertEquals(true, ankylosaurus2.rampage());

    }

    @Test
    public void willNotRampageUnlessHungry() {
        assertEquals(false, ankylosaurus.rampage());
    }

}
