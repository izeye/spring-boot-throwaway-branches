package learningtest.java.lang;

import com.izeye.throwaway.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by izeye on 16. 3. 4..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class ClassLoaderTests {

	@Test
	public void test() {
		ClassLoader classLoader = getClass().getClassLoader();
		while (classLoader != null) {
			System.out.println(classLoader);
			classLoader = classLoader.getParent();
		}
	}

}
