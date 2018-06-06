package com.example.user.jurassicpark;

import com.example.user.jurassicpark.DinosaurBehaviour.IFly;
import com.example.user.jurassicpark.Dinosaurs.FeedType;
import com.example.user.jurassicpark.Dinosaurs.Pteranodon;
import com.example.user.jurassicpark.Paddocks.Aviary;
import com.example.user.jurassicpark.Paddocks.PaddockType;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AviaryTest {
    Aviary aviary;
    Pteranodon pteranodon;
    ArrayList<IFly> dinosaurList;

    @Before
    public void before(){
        pteranodon = new Pteranodon(FeedType.CARNIVORE, "Pteranodon", "Sylvester");
        dinosaurList = new ArrayList<>();
        dinosaurList.add(pteranodon);

        aviary = new Aviary(PaddockType.AVIARY, dinosaurList);
    }

    @Test
    public void canGetType(){
        assertEquals(PaddockType.AVIARY, aviary.getType());
    }

    @Test
    public void canGetBoundaryHealth(){
        assertEquals(100, aviary.getBoundaryHealth());
    }

    @Test
    public void canSetBoundaryHealth(){
        assertEquals(40, aviary.setBoundaryHealth(40));
    }

    @Test
    public void canCountDinosaurs(){
        assertEquals(1, aviary.dinosaurCount());
    }

    @Test
    public void canAddDinosaur(){
        aviary.addDinosaur(pteranodon);
        assertEquals(2, aviary.dinosaurCount());
    }

    @Test
    public void canRemoveDinosaur(){
        aviary.removeDinosaur(pteranodon);
        assertEquals(0, aviary.dinosaurCount());
    }

    @Test
    public void canFeedDinosaur(){
        assertEquals("Mmmm", aviary.feedDinosaur(pteranodon));
        assertEquals(1, pteranodon.getHungerLevel());
    }

    @Test
    public void dinosaurCanCauseDamage(){
        Pteranodon spyPteranodon = Mockito.spy(pteranodon);

        Mockito.when(spyPteranodon.getHungerLevel()).thenReturn(8);
        aviary.dinosaurHitBoundary(spyPteranodon);
        assertEquals(50, aviary.getBoundaryHealth());
    }

    @Test
    public void boundaryHealthCannotGoBelowZero(){
        Pteranodon spyPteranodon = Mockito.spy(pteranodon);

        Mockito.when(spyPteranodon.getHungerLevel()).thenReturn(8);
        aviary.dinosaurHitBoundary(spyPteranodon);
        aviary.dinosaurHitBoundary(spyPteranodon);

        assertEquals(0, aviary.getBoundaryHealth());
    }

    @Test
    public void dinosaurCanEscape(){
        Pteranodon spyPteranodon = Mockito.spy(pteranodon);

        Mockito.when(spyPteranodon.getHungerLevel()).thenReturn(8);
        assertEquals("Run for your lives!!", aviary.dinosaurEscapes(spyPteranodon));
        assertEquals(0, aviary.getBoundaryHealth());
    }

    @Test
    public void dinosaurCannotEscapeUnlessRampaging(){
        Pteranodon spyPteranodon = Mockito.spy(pteranodon);

        Mockito.when(spyPteranodon.getHungerLevel()).thenReturn(2);
        assertEquals("Run for your lives!!", aviary.dinosaurEscapes(spyPteranodon));
        assertEquals(100, aviary.getBoundaryHealth());
    }



}
