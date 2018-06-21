package learningtest.org.springframework.web.util;

import java.nio.charset.StandardCharsets;

import org.springframework.web.util.UriUtils;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link UriUtils}.
 *
 * @author Johnny Lim
 */
public class UriUtilsTests {

	@Test
	public void encode() {
		assertThat(UriUtils.encode("a=${b}", StandardCharsets.UTF_8)).isEqualTo("a%3D%24%7Bb%7D");
	}

	@Test
	public void encodeQuery() {
		assertThat(UriUtils.encodeQuery("a=${b}", StandardCharsets.UTF_8)).isEqualTo("a=$%7Bb%7D");
	}

}
