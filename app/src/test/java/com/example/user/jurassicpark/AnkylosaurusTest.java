package com.example.user.jurassicpark;

import com.example.user.jurassicpark.Dinosaurs.Ankylosaurus;
import com.example.user.jurassicpark.Dinosaurs.FeedType;
import org.mockito.*;


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
        Ankylosaurus spyAnkylosaurus = Mockito.spy(ankylosaurus);

        Mockito.when(spyAnkylosaurus.getHungerLevel()).thenReturn(6);
        assertEquals(true, spyAnkylosaurus.rampage());
    }

    @Test
    public void willNotRampageUnlessHungry(){
        Ankylosaurus spyAnkylosaurus = Mockito.spy(ankylosaurus);

        Mockito.when(spyAnkylosaurus.getHungerLevel()).thenReturn(1);
        assertEquals(false, spyAnkylosaurus.rampage());
    }

}
