package com.example.user.jurassicpark;

import com.example.user.jurassicpark.Dinosaurs.Brachiosaurus;
import com.example.user.jurassicpark.Dinosaurs.FeedType;
import com.example.user.jurassicpark.Dinosaurs.TRex;
import com.example.user.jurassicpark.Paddocks.PaddockType;
import com.example.user.jurassicpark.Paddocks.TRexPaddock;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TRexPaddockTest {
    TRexPaddock tRexPaddock;
    TRex tRex;
    ArrayList<TRex> dinosaurList;

    @Before
    public void before(){
        tRex = new TRex(FeedType.CARNIVORE, "TRex", "Bruce", 3);
        dinosaurList = new ArrayList<>();
        dinosaurList.add(tRex);

        tRexPaddock = new TRexPaddock(PaddockType.TREX_PADDOCK, dinosaurList);
    }

    @Test
    public void canGetType(){
        assertEquals(PaddockType.TREX_PADDOCK, tRexPaddock.getType());
    }

    @Test
    public void canGetBoundaryHealth(){
        assertEquals(100, tRexPaddock.getBoundaryHealth());
    }

    @Test
    public void canCountDinosaurs(){
        assertEquals(1, tRexPaddock.dinosaurCount());
    }

    @Test
    public void canAddDinosaur(){
        tRexPaddock.addDinosaur(tRex);
        assertEquals(2, tRexPaddock.dinosaurCount());
    }

    @Test
    public void canRemoveDinosaur(){
        tRexPaddock.removeDinosaur(tRex);
        assertEquals(0, tRexPaddock.dinosaurCount());
    }

    @Test
    public void canFeedDinosaur(){
        assertEquals("Mmmm", tRexPaddock.feedDinosaur(tRex));
        assertEquals(1, tRex.getHungerLevel());
    }

    @Test
    public void dinosaurCanRampage(){
        TRex tRex2 = new TRex(FeedType.CARNIVORE, "TRex", "Arty", 7);
        tRexPaddock.dinosaurHitBoundary(tRex2);
        assertEquals(40, tRexPaddock.getBoundaryHealth());
    }

    @Test
    public void dinosaurCanEscape(){
        TRex tRex2 = new TRex(FeedType.CARNIVORE, "TRex", "Arty", 7);
        assertEquals("Run for your lives!!", tRexPaddock.dinosaurEscapes(tRex2));
        assertEquals(0, tRexPaddock.getBoundaryHealth());
    }

    @Test
    public void dinosaurCannotEscapeUnlessRampaging(){
        tRexPaddock.dinosaurEscapes(tRex);
        assertEquals(100, tRexPaddock.getBoundaryHealth());
    }
}
