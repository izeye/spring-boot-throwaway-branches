package learningtest.org.springframework.context.support;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.LiveBeansView;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by izeye on 16. 4. 21..
 */
public class LiveBeansViewTests {

	@Test
	public void test() {
		AnnotationConfigApplicationContext context
				= new AnnotationConfigApplicationContext();
		context.register(TestConfiguration.class);
		context.getBeanFactory().registerSingleton("bean2", new MyBean());
		context.refresh();

		LiveBeansView view = new LiveBeansView();
		view.setApplicationContext(context);

		String json = view.getSnapshotAsJson();
		assertThat(json).contains("bean1");
		
		// FIXME: Should work with `contains()` not `doesNotContain()`.
		assertThat(json).doesNotContain("bean2");
	}
	
	@Configuration
	public static class TestConfiguration {
		
		@Bean
		public MyBean bean1() {
			return new MyBean();
		}
		
	}

	private static class MyBean {
	}
	
}
