package learningtest.org.springframework.web;

import java.net.URI;

import org.springframework.web.util.UriComponentsBuilder;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Tests for {@link UriComponentsBuilder}.
 *
 * @author Johnny Lim
 */
public class UriComponentBuilderTests {

	// FIXME: See https://github.com/spring-projects/spring-framework/issues/19394
	@Ignore
	@Test
	public void testFromHttpUrlBuildEncoded() {
		// Works with '%20' for a space
		String httpUrl = "http://localhost:8080/test/print?value=%EA%B0%80%20%EB%82%98";
		URI uri = UriComponentsBuilder.fromHttpUrl(httpUrl).build(true).toUri();
		System.out.println(uri);

		// but doesn't work with '+' for a space.
		httpUrl = "http://localhost:8080/test/print?value=%EA%B0%80+%EB%82%98";
		uri = UriComponentsBuilder.fromHttpUrl(httpUrl).build(true).toUri();
		System.out.println(uri);
	}

}
