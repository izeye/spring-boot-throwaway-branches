package learningtest.java.util;

import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by izeye on 15. 10. 5..
 */
class DateTests {
	
	@Test
	void testBeforeAndAfter() {
		Calendar calendar = Calendar.getInstance();
		Date currentTime = calendar.getTime();
		
		calendar.setTimeInMillis(currentTime.getTime() - 1);
		Date beforeTime = calendar.getTime();
		assertThat(beforeTime.before(currentTime)).isTrue();
		
		calendar.setTimeInMillis(currentTime.getTime() + 1);
		Date afterTime = calendar.getTime();
		assertThat(afterTime.after(currentTime)).isTrue();
	}
	
}
