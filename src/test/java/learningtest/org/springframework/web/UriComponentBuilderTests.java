package learningtest.org.springframework.web;

import java.net.URI;

import org.springframework.web.util.UriComponentsBuilder;

import org.junit.Test;

/**
 * Tests for {@link UriComponentsBuilder}.
 *
 * @author Johnny Lim
 */
public class UriComponentBuilderTests {

	@Test
	public void testFromHttpUrlBuildEncoded() {
		String httpUrl = "http://localhost:8080/test/print?value=%EA%B0%80+%EB%82%98";
		URI uri = UriComponentsBuilder.fromHttpUrl(httpUrl).build(true).toUri();
		System.out.println(uri);
	}

}
