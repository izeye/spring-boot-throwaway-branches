package learningtest.org.springframework.web.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.springframework.web.util.UriTemplate;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link UriTemplate}.
 *
 * @author Johnny Lim
 */
class UriTemplateTests {

	@Test
	void expand() {
		UriTemplate uriTemplate = new UriTemplate("https://www.google.com/{a}/{b}");
		assertThat(uriTemplate.expand("a a", "b b").toString())
				.isEqualTo("https://www.google.com/a%20a/b%20b");
	}

	@Disabled("expand() doesn't work with URL somehow.")
	@Test
	void expandWithUrl() throws UnsupportedEncodingException {
		UriTemplate uriTemplate = new UriTemplate("https://www.google.com/{a}/{b}");
		String url = "https://www.izeye.com/";
		assertThat(uriTemplate.expand("a a", url))
				.isEqualTo("https://www.google.com/a%20a/" + URLEncoder.encode(url, "UTF-8"));
	}

}
