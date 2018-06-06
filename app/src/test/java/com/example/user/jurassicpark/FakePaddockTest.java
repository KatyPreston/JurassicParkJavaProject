package com.example.user.jurassicpark;

import com.example.user.jurassicpark.Dinosaurs.Ankylosaurus;
import com.example.user.jurassicpark.Dinosaurs.FeedType;
import com.example.user.jurassicpark.Dinosaurs.Pteranodon;
import com.example.user.jurassicpark.MockTestable.FakeDinosaur;
import com.example.user.jurassicpark.MockTestable.FakePaddock;
import com.example.user.jurassicpark.Paddocks.PaddockType;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FakePaddockTest {
    FakePaddock paddock;
    FakeDinosaur dinosaur, dinosaur2;

    @Before
    public void before(){
        dinosaur = new FakeDinosaur(8);
        dinosaur2 = new FakeDinosaur(2);
        paddock = new FakePaddock(PaddockType.AVIARY, dinosaur);
    }



    @Test
    public void dinosaurCanCauseDamage(){
        paddock.dinosaurHitBoundary(dinosaur);
        assertEquals(50, paddock.getBoundaryHealth());
    }

    @Test
    public void boundaryHealthCannotGoBelowZero(){
        paddock.dinosaurHitBoundary(dinosaur);
        paddock.dinosaurHitBoundary(dinosaur);
        paddock.dinosaurHitBoundary(dinosaur);
        assertEquals(0, paddock.getBoundaryHealth());
    }

    @Test
    public void dinosaurCanEscape(){
        assertEquals("Run for your lives!!", paddock.dinosaurEscapes(dinosaur));
        assertEquals(0, paddock.getBoundaryHealth());
    }

    @Test
    public void dinosaurCannotEscapeUnlessRampaging(){
        paddock.dinosaurEscapes(dinosaur2);
        assertEquals(100, paddock.getBoundaryHealth());
    }

}
