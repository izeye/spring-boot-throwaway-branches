package learningtest.org.springframework.mock.web;

import java.util.Collections;

import org.springframework.mock.web.MockHttpServletRequest;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link MockHttpServletRequest}.
 *
 * @author Johnny Lim
 */
class MockHttpServletRequestTests {

	@Test
	void addHeaderAndRemoveHeader() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		String headerName = "Test";

		request.addHeader(headerName, "1");
		request.addHeader(headerName, "2");
		assertThat(Collections.list(request.getHeaders(headerName))).containsExactly("1", "2");

		request.removeHeader(headerName);
		assertThat(request.getHeaders(headerName).hasMoreElements()).isFalse();
	}

}
