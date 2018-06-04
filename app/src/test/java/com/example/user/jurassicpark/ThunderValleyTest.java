package com.example.user.jurassicpark;

import com.example.user.jurassicpark.DinosaurBehaviour.IWalk;
import com.example.user.jurassicpark.Dinosaurs.Brachiosaurus;
import com.example.user.jurassicpark.Dinosaurs.FeedType;
import com.example.user.jurassicpark.Paddocks.PaddockType;
import com.example.user.jurassicpark.Paddocks.ThunderValley;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ThunderValleyTest {
    ThunderValley thunderValley;
    Brachiosaurus brachiosaurus;
    ArrayList<IWalk> dinosaurList;

    @Before
    public void before(){
        brachiosaurus = new Brachiosaurus(FeedType.HERBIVORE, "Brachiosaurus", "Cecilia");
        dinosaurList = new ArrayList<>();
        dinosaurList.add(brachiosaurus);

        thunderValley = new ThunderValley(PaddockType.THUNDERVALLEY, dinosaurList);
    }

    @Test
    public void canGetType(){
        assertEquals(PaddockType.THUNDERVALLEY, thunderValley.getType());
    }

    @Test
    public void canCountDinosaurs(){
        assertEquals(1, thunderValley.dinosaurCount());
    }

    @Test
    public void canAddDinosaur(){
        thunderValley.addDinosaur(brachiosaurus);
        assertEquals(2, thunderValley.dinosaurCount());
    }
}
