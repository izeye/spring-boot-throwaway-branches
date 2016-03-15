package learningtest.org.springframework.core.io.support;

import org.junit.Test;
import org.springframework.boot.diagnostics.FailureAnalysisReporter;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;

/**
 * Created by izeye on 16. 3. 15..
 */
public class SpringFactoriesLoaderTests {
	
	@Test
	public void testLoadFactories() {
		ClassLoader classLoader = getClass().getClassLoader();
		
//		List<FailureAnalyzer> analyzers = SpringFactoriesLoader
//				.loadFactories(FailureAnalyzer.class, classLoader);
//		System.out.println(analyzers);
		
		List<FailureAnalysisReporter> reporters = SpringFactoriesLoader
				.loadFactories(FailureAnalysisReporter.class, classLoader);
		System.out.println(reporters);
	}
	
}
