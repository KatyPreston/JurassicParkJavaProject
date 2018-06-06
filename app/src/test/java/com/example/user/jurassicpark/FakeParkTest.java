package com.example.user.jurassicpark;

import com.example.user.jurassicpark.DinosaurBehaviour.IFly;
import com.example.user.jurassicpark.MockTestable.FakeDinosaur;
import com.example.user.jurassicpark.MockTestable.FakePaddock;
import com.example.user.jurassicpark.MockTestable.FakePark;
import com.example.user.jurassicpark.Paddocks.Aviary;
import com.example.user.jurassicpark.Paddocks.PaddockType;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FakeParkTest {
    FakePark park;
    FakePaddock paddock;
    FakeDinosaur dinosaur;

    @Before
    public void before(){
        dinosaur = new FakeDinosaur(7);
        paddock = new FakePaddock(PaddockType.VELOCIRAPTOR_PADDOCK, dinosaur);
        park = new FakePark(paddock);
    }

    @Test
    public void canRepairPaddockBoundary(){ ;
        paddock.dinosaurHitBoundary(dinosaur);
        assertEquals(50, paddock.getBoundaryHealth());
        park.repairPaddock(paddock);
        assertEquals(100, paddock.getBoundaryHealth());
        assertEquals(-50, park.totalRevenue(), 0.1);
    }
}
