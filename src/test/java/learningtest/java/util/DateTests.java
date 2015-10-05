package learningtest.java.util;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertTrue;

/**
 * Created by izeye on 15. 10. 5..
 */
public class DateTests {
	
	@Test
	public void testBeforeAndAfter() {
		Calendar calendar = Calendar.getInstance();
		Date currentTime = calendar.getTime();
		
		calendar.setTimeInMillis(currentTime.getTime() - 1);
		Date beforeTime = calendar.getTime();
		assertTrue(beforeTime.before(currentTime));
		
		calendar.setTimeInMillis(currentTime.getTime() + 1);
		Date afterTime = calendar.getTime();
		assertTrue(afterTime.after(currentTime));
		
	}
	
}
