package com.example.user.jurassicpark;

import com.example.user.jurassicpark.DinosaurBehaviour.IWalk;
import com.example.user.jurassicpark.Dinosaurs.Ankylosaurus;
import com.example.user.jurassicpark.Dinosaurs.Brachiosaurus;
import com.example.user.jurassicpark.Dinosaurs.FeedType;
import com.example.user.jurassicpark.Paddocks.CloudForest;
import com.example.user.jurassicpark.Paddocks.PaddockType;
import org.mockito.*;
import static org.mockito.Mockito.*;


import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class AnkylosaurusTest {
    Ankylosaurus ankylosaurus;

    @Before
    public void before() {
        ankylosaurus = new Ankylosaurus(FeedType.HERBIVORE, "Ankylosaurus", "Stompy");
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
    public void canGetRampagePower() {
        assertEquals(40, ankylosaurus.getRampagePower());
    }

    @Test
    public void canGetHungerLevel(){
        Ankylosaurus ankylosaurus1 = new Ankylosaurus(FeedType.HERBIVORE, "Ankylosaurus", "Bert");
        Ankylosaurus spyAnkylosaurus = Mockito.spy(ankylosaurus1);

        Mockito.when(spyAnkylosaurus.getHungerLevel()).thenReturn(8);
        assertEquals(8, spyAnkylosaurus.getHungerLevel());
    }

    @Test
    public void canEat() {
        ankylosaurus.eat();
        assertEquals(1, ankylosaurus.getHungerLevel());
    }

    @Test
    public void canRampage(){
        Ankylosaurus ankylosaurus1 = new Ankylosaurus(FeedType.HERBIVORE, "Ankylosaurus", "Bert");
        Ankylosaurus spyAnkylosaurus = Mockito.spy(ankylosaurus1);

        Mockito.when(spyAnkylosaurus.rampage()).thenReturn(true);
        assertEquals(true, spyAnkylosaurus.rampage());
    }

    @Test
    public void willNotRampageUnlessHungry(){
        Ankylosaurus ankylosaurus1 = new Ankylosaurus(FeedType.HERBIVORE, "Ankylosaurus", "Bert");
        Ankylosaurus spyAnkylosaurus = Mockito.spy(ankylosaurus1);

        Mockito.when(spyAnkylosaurus.rampage()).thenReturn(false);
        assertEquals(false, spyAnkylosaurus.rampage());
    }


}
