package com.itarle;

import java.time.Instant;
import java.util.List;

public class ReallyBadExchangeFeed{
    
    public List<Tick> batchRequestTicks() {
        Tick t1 = getTick(Instant.parse("2018-01-01T01:01:01Z"), 100.0);
        Tick t2 = getTick(Instant.parse("2018-01-01T01:01:02Z"), 101.0);
        Tick t3 = getTick(Instant.parse("2018-01-01T01:01:05Z"), 100.5);
        Tick t4 = getTick(Instant.parse("2018-01-01T01:01:09Z"), 101.0);
        Tick t5 = getTick(Instant.parse("2018-01-01T01:01:16Z"), 102.0);
        return List.of(t1, t2, t3, t4, t5);
    }
    
    public List<Fill> batchRequestFills() {
        Fill f1 = getFill(Instant.parse("2018-01-01T01:01:02Z"), 300);
        Fill f2 = getFill(Instant.parse("2018-01-01T01:01:03Z"), 150);
        Fill f3 = getFill(Instant.parse("2018-01-01T01:01:06Z"), 400);
        Fill f4 = getFill(Instant.parse("2018-01-01T01:01:06Z"), 200);
        Fill f5 = getFill(Instant.parse("2018-01-01T01:01:06Z"), 100);
        Fill f6 = getFill(Instant.parse("2018-01-01T01:01:15Z"), 900);
        return List.of(f1, f2, f3, f4, f5, f6);
    }
    
    public static Fill getFill(Instant time, double quantity)
    {
        Fill result = new Fill();
        result.time = time;
        result.quantity = quantity;
        return result;
    }
    
    public static Tick getTick(Instant time, double price) {
        Tick result = new Tick();
        result.time = time;
        result.price = price;
        return result;
    }
}
