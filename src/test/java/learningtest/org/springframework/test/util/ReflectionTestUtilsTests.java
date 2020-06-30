package learningtest.org.springframework.test.util;

import org.springframework.test.util.ReflectionTestUtils;

import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by izeye on 15. 10. 2..
 */
class ReflectionTestUtilsTests {
	
	@Test
	void testGetField() {
		AtomicBoolean created = (AtomicBoolean) ReflectionTestUtils.getField(
				ApplicationPidFileWriter.class, "created");
		assertThat(created.get()).isEqualTo(ApplicationPidFileWriter.isCreated());
		
		created.set(true);
		assertThat(created.get()).isEqualTo(ApplicationPidFileWriter.isCreated());
	}
	
	static class ApplicationPidFileWriter {

		private static final AtomicBoolean created = new AtomicBoolean(false);
		
		public static boolean isCreated() {
			return created.get();
		}
		
	}
	
}
