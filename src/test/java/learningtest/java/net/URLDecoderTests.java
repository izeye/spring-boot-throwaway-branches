package learningtest.java.net;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 10. 7..
 */
public class URLDecoderTests {
	
	@Test
	public void testDecode() throws UnsupportedEncodingException {
		String expected = "type=KOREAN&name=가&address=나";
		String decoded = URLDecoder.decode("type=KOREAN&name=%EA%B0%80&address=%EB%82%98", "UTF-8");
		System.out.println(decoded);
		assertThat(decoded, is(expected));
	}
	
}
