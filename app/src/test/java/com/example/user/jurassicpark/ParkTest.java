package com.example.user.jurassicpark;

import com.example.user.jurassicpark.Paddocks.Paddock;
import com.example.user.jurassicpark.Park.Park;
import com.example.user.jurassicpark.Visitors.Visitor;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ParkTest {
    Park park;
    Visitor visitor;
    Paddock paddock;
    ArrayList<Paddock> paddocks;
    ArrayList<Visitor> visitors;

    @Before
    public void before(){
        paddocks = new ArrayList<>();
        visitors = new ArrayList<>();
        park = new Park(paddocks, visitors, 0);
    }

    @Test
    public void canGetTotalMoney(){
        assertEquals(0, park.totalMoney(), 0.1);
    }

    @Test
    public void canAddVisitor(){
        park.addVisitor(visitor);
        assertEquals(1, park.visitorCount());
    }

    @Test
    public void canRemoveVisitor(){
        park.addVisitor(visitor);
        park.removeVisitor(visitor);
        assertEquals(0, park.visitorCount());
    }

    @Test
    public void canCountVisitors(){
        assertEquals(0, park.visitorCount());

    }
}
