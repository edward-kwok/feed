package com.itarle;

import java.util.List;

public class VWAPCalculator {
    private TickService tickService;

    public VWAPCalculator(TickService tickService) {
        this.tickService = tickService;
    }

    public double calculateVWAP(List<Fill> fills){
        double vwap = 0;
        double turnover = 0;
        int quantity = 0;


        for (Fill fill : fills) {
            double price = tickService.getPrice(fill.getTime());
            double fillTurnover = price * fill.getQuantity();
            turnover += fillTurnover;
            quantity += fill.getQuantity();
        }
        vwap = turnover / quantity;
        return vwap;
    }
}
