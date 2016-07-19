package learningtest.org.springframework.context.support;

import com.izeye.throwaway.config.AnotherPrototypeObject;
import com.izeye.throwaway.config.PrototypeObjectFactoryBean;
import com.izeye.throwaway.config.SingletonObject;
import com.izeye.throwaway.config.SmartPrototypeObjectFactoryBean;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.LiveBeansView;

import java.io.IOException;

/**
 * Created by izeye on 16. 7. 19..
 */
public class LiveBeansViewBeanScopeTests {
	
	@Test
	public void test() throws IOException {
		AnnotationConfigApplicationContext context
				= new AnnotationConfigApplicationContext();
		context.register(BeanScopeTestConfig.class);
		context.refresh();
		
		LiveBeansView liveBeansView = new LiveBeansView();
		liveBeansView.setApplicationContext(context);
		String snapshotAsJson = liveBeansView.getSnapshotAsJson();
		System.out.println(snapshotAsJson);
	}
	
	@Configuration
	static class BeanScopeTestConfig {

		@Bean
		public PrototypeObjectFactoryBean prototypeObject() {
			return new PrototypeObjectFactoryBean();
		}

		@Bean
		public SmartPrototypeObjectFactoryBean smartPrototypeObject() {
			return new SmartPrototypeObjectFactoryBean();
		}

		@Bean
		@Scope(scopeName = "prototype")
		public AnotherPrototypeObject anotherPrototypeObject() {
			return new AnotherPrototypeObject();
		}

		@Bean
		public SingletonObject singletonObject() {
			return new SingletonObject();
		}

	}
	
}
