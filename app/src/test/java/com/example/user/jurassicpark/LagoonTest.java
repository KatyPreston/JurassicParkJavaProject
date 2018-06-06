package com.example.user.jurassicpark;

import com.example.user.jurassicpark.DinosaurBehaviour.ISwim;
import com.example.user.jurassicpark.Dinosaurs.FeedType;
import com.example.user.jurassicpark.Dinosaurs.Mosasaurus;
import com.example.user.jurassicpark.Paddocks.Lagoon;
import com.example.user.jurassicpark.Paddocks.PaddockType;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LagoonTest {
    Lagoon lagoon;
    Mosasaurus mosasaurus;
    ArrayList<ISwim> dinosaurList;

    @Before
    public void before(){
        mosasaurus = new Mosasaurus(FeedType.CARNIVORE, "Mosasaurus", "Simon");
        dinosaurList = new ArrayList<>();
        dinosaurList.add(mosasaurus);

        lagoon = new Lagoon(PaddockType.LAGOON, dinosaurList);
    }

    @Test
    public void canGetType(){
        assertEquals(PaddockType.LAGOON, lagoon.getType());
    }

    @Test
    public void canGetBoundaryHealth(){
        assertEquals(100, lagoon.getBoundaryHealth());
    }

    @Test
    public void canSetBoundaryHealth(){
        assertEquals(40, lagoon.setBoundaryHealth(40));
    }

    @Test
    public void canCountDinosaurs(){
        assertEquals(1, lagoon.dinosaurCount());
    }

    @Test
    public void canAddDinosaur(){
        lagoon.addDinosaur(mosasaurus);
        assertEquals(2, lagoon.dinosaurCount());
    }

    @Test
    public void canRemoveDinosaur(){
        lagoon.removeDinosaur(mosasaurus);
        assertEquals(0, lagoon.dinosaurCount());
    }

    @Test
    public void canFeedDinosaur(){
        assertEquals("Mmmm", lagoon.feedDinosaur(mosasaurus));
        assertEquals(1, mosasaurus.getHungerLevel());
    }

    @Test
    public void dinosaurCanCauseDamage(){
        Mosasaurus spyMosasaurus = Mockito.spy(mosasaurus);

        Mockito.when(spyMosasaurus.getHungerLevel()).thenReturn(8);
        lagoon.dinosaurHitBoundary(spyMosasaurus);
        assertEquals(80, lagoon.getBoundaryHealth());
    }

    @Test
    public void boundaryHealthCannotGoBelowZero(){
        Mosasaurus spyMosasaurus = Mockito.spy(mosasaurus);

        Mockito.when(spyMosasaurus.getHungerLevel()).thenReturn(8);
        lagoon.dinosaurHitBoundary(spyMosasaurus);
        lagoon.dinosaurHitBoundary(spyMosasaurus);
        lagoon.dinosaurHitBoundary(spyMosasaurus);
        lagoon.dinosaurHitBoundary(spyMosasaurus);
        lagoon.dinosaurHitBoundary(spyMosasaurus);
        assertEquals(0, lagoon.getBoundaryHealth());
    }

    @Test
    public void dinosaurCanEscape(){
        Mosasaurus spyMosasaurus = Mockito.spy(mosasaurus);

        Mockito.when(spyMosasaurus.getHungerLevel()).thenReturn(8);
        assertEquals("Run for your lives!!", lagoon.dinosaurEscapes(spyMosasaurus));
        assertEquals(0, lagoon.getBoundaryHealth());
    }

    @Test
    public void dinosaurCannotEscapeUnlessRampaging(){
        Mosasaurus spyMosasaurus = Mockito.spy(mosasaurus);

        Mockito.when(spyMosasaurus.getHungerLevel()).thenReturn(5);
        assertEquals("Run for your lives!!", lagoon.dinosaurEscapes(spyMosasaurus));
        assertEquals(100, lagoon.getBoundaryHealth());
    }

}
