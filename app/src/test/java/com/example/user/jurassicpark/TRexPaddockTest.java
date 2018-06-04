package com.example.user.jurassicpark;

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
        tRex = new TRex(FeedType.CARNIVORE, "TRex", "Bruce");
        dinosaurList = new ArrayList<>();
        dinosaurList.add(tRex);

        tRexPaddock = new TRexPaddock(PaddockType.TREX_PADDOCK, dinosaurList);
    }

    @Test
    public void canGetType(){
        assertEquals(PaddockType.TREX_PADDOCK, tRexPaddock.getType());
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
}
