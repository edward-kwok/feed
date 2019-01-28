import com.itarle.Fill;
import com.itarle.TickService;
import com.itarle.ReallyBadExchangeFeed;
import com.itarle.VWAPCalculator;
import org.junit.Before;
import org.junit.Test;

import java.time.Instant;

import static org.junit.Assert.assertEquals;

public class TickServiceTest {

    TickService tickService = new TickService();
    ReallyBadExchangeFeed feed = new ReallyBadExchangeFeed();

    @Before
    public void importTicks(){
        tickService.importTicks(feed.batchRequestTicks());
    }


    @Test
    public void shouldTimeInRange(){
        assertEquals(101, tickService.getPrice(Instant.parse("2018-01-01T01:01:03Z")),0.001);
    }

    @Test
    public void shouldCanFindLastTickPrice(){
        assertEquals(102, tickService.getPrice(Instant.parse("2018-01-01T01:01:17Z")),0.001);
    }

    @Test
    public void shouldReturnCorrectVWAP(){
        VWAPCalculator cal = new VWAPCalculator(tickService);


        assertEquals(100.8292682927,cal.calculateVWAP(feed.batchRequestFills()) ,0.0000000001);


    }

}
