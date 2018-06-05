package com.example.user.jurassicpark;

import com.example.user.jurassicpark.DinosaurBehaviour.ISwim;
import com.example.user.jurassicpark.Dinosaurs.FeedType;
import com.example.user.jurassicpark.Dinosaurs.TRex;
import com.example.user.jurassicpark.Paddocks.Lagoon;
import com.example.user.jurassicpark.Paddocks.PaddockType;
import com.example.user.jurassicpark.Paddocks.TRexPaddock;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TRexTest {
    TRex tRex;

    @Before
    public void before(){
        tRex = new TRex(FeedType.CARNIVORE, "TRex", "Grumpy", 8);
    }

    @Test
    public void canGetFeedType(){
        assertEquals(FeedType.CARNIVORE, tRex.getFeedType());
    }

    @Test
    public void canGeType(){
        assertEquals("TRex", tRex.getType());
    }

    @Test
    public void canGetName(){
        assertEquals("Grumpy", tRex.getName());
    }

    @Test
    public void canGetHungerLevel(){
        assertEquals(8, tRex.getHungerLevel());
    }

    @Test
    public void canGetRampagePower(){
        assertEquals(60, tRex.getRampagePower());
    }

    @Test
    public void canEat(){
        tRex.eat();
        assertEquals(1, tRex.getHungerLevel());
    }

    @Test
    public void canRampage(){
        ArrayList<TRex> dinosaurs = new ArrayList<>();
        TRexPaddock tRexPaddock= new TRexPaddock(PaddockType.TREX_PADDOCK, dinosaurs);

        assertEquals("Grrr Rooaaar", tRex.rampage(tRexPaddock));
        assertEquals(40, tRexPaddock.getBoundaryHealth());

    }
}
