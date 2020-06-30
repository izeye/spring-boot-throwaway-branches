package learningtest.java.net;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by izeye on 15. 10. 7..
 */
class URLDecoderTests {
	
	@Test
	void testDecode() throws UnsupportedEncodingException {
		String expected = "type=KOREAN&name=가&address=나";
		String decoded = URLDecoder.decode("type=KOREAN&name=%EA%B0%80&address=%EB%82%98", "UTF-8");
		System.out.println(decoded);
		assertThat(decoded).isEqualTo(expected);
	}
	
}
