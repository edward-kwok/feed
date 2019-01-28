package com.itarle;

public class Application{

    public static void main(String[] args) {
	    System.out.println("We're up and running. Well done.");

	    var feed = new ReallyBadExchangeFeed();
    
        var ticks = feed.batchRequestTicks();
	    ticks.forEach(System.out::println);
    
        var fills = feed.batchRequestFills();
	    fills.forEach(System.out::println);

	    TickService chk = new TickService();
	    chk.importTicks(ticks);
	    double vwap = 0;
	    double turnover = 0;
	    int quantity = 0;
	    for (Fill fill : fills) {
	        double price = chk.getPrice(fill.time);
	        double fillTurnover = price * fill.quantity;
	        turnover += fillTurnover;
	        quantity += fill.quantity;
        }

	    vwap = turnover / quantity;
	    System.out.println(String.format("This is the VWAP: %.10f", vwap));

    }

}

