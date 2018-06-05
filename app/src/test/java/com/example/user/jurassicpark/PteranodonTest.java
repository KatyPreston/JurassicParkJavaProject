package com.example.user.jurassicpark;

import com.example.user.jurassicpark.DinosaurBehaviour.IFly;
import com.example.user.jurassicpark.DinosaurBehaviour.ISwim;
import com.example.user.jurassicpark.Dinosaurs.FeedType;
import com.example.user.jurassicpark.Dinosaurs.Pteranodon;
import com.example.user.jurassicpark.Paddocks.Aviary;
import com.example.user.jurassicpark.Paddocks.Lagoon;
import com.example.user.jurassicpark.Paddocks.PaddockType;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PteranodonTest {
    Pteranodon pteranodon;

    @Before
    public void before(){
        pteranodon = new Pteranodon(FeedType.HERBIVORE, "Pteranodon", "Elvis", 3);
    }

    @Test
    public void canGetFeedType(){
        assertEquals(FeedType.HERBIVORE, pteranodon.getFeedType());
    }

    @Test
    public void canGeType(){
        assertEquals("Pteranodon", pteranodon.getType());
    }

    @Test
    public void canGetName(){
        assertEquals("Elvis", pteranodon.getName());
    }

    @Test
    public void canGetHungerLevel(){
        assertEquals(3, pteranodon.getHungerLevel());
    }

    @Test
    public void canGetRampagePower(){
        assertEquals(50, pteranodon.getRampagePower());
    }

    @Test
    public void canEat(){
        pteranodon.eat();
        assertEquals(1, pteranodon.getHungerLevel());
    }

    @Test
    public void canRampage(){
        ArrayList<IFly> dinosaurs = new ArrayList<>();
        Aviary aviary= new Aviary(PaddockType.AVIARY, dinosaurs);

        assertEquals("Swoosh Caaawww", pteranodon.rampage(aviary));
        assertEquals(50, aviary.getBoundaryHealth());

    }
}
