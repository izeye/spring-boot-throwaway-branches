package learningtest.org.springframework.core.io.support;

import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by izeye on 16. 3. 6..
 */
public class PathMatchingResourcePatternResolverTests {

	PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
	
	@Test
	public void testGetResources() {
		try {
			String locationPattern = "com/izeye/throwaway/domain/**/*.class";
			Resource[] resources = resolver.getResources(locationPattern);
			System.out.println(Arrays.toString(resources));
			
			locationPattern = "classpath*:com/izeye/throwaway/domain/**/*.class";
			resources = resolver.getResources(locationPattern);
			System.out.println(Arrays.toString(resources));
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}
	
}
