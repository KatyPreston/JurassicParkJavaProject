package com.example.user.jurassicpark;

import com.example.user.jurassicpark.DinosaurBehaviour.IFly;
import com.example.user.jurassicpark.Dinosaurs.FeedType;
import com.example.user.jurassicpark.Dinosaurs.Pteranodon;
import com.example.user.jurassicpark.Paddocks.Aviary;
import com.example.user.jurassicpark.Paddocks.PaddockType;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AviaryTest {
    Aviary aviary;
    Pteranodon pteranodon;
    ArrayList<IFly> dinosaurList;

    @Before
    public void before(){
        pteranodon = new Pteranodon(FeedType.CARNIVORE, "Pteranodon", "Sylvester", 2);
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

}
