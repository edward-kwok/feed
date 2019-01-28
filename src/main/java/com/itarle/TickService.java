package com.itarle;

import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;

import java.time.Instant;
import java.util.List;

public class TickService {
    RangeMap<Instant,Double> rangeMap = TreeRangeMap.create();

    public void importTicks(List<Tick> ticks) {
        for(int i = 1; i < ticks.size(); i++) {
            rangeMap.put(Range.closedOpen(ticks.get(i - 1).time,ticks.get(i).time),ticks.get(i-1).price);
        }

        rangeMap.put(Range.atLeast(ticks.get(ticks.size() -1 ).time),ticks.get(ticks.size() -1 ).price);
    }

    public double getPrice(Instant parse) {
        return rangeMap.get(parse);
    }
}
