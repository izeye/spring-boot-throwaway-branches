package com.izeye.throwaway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.MockMvc;

import com.izeye.throwaway.web.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.RestController;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tests for {@link HomeController}.
 *
 * @author Johnny Lim
 */
@SpringBootTest
@AutoConfigureMockMvc
class HomeControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void responseEntityNoCacheControl() throws Exception {
		this.mockMvc.perform(get("/responseEntity"))
				.andExpect(status().isOk())
				.andExpect(header().doesNotExist(HttpHeaders.CACHE_CONTROL));
	}

	@Test
	void responseEntityCacheControlEmpty() throws Exception {
		this.mockMvc.perform(get("/responseEntityCacheControlEmpty"))
				.andExpect(status().isOk())
				.andExpect(header().doesNotExist(HttpHeaders.CACHE_CONTROL));
	}

	@Test
	void responseEntityCacheControlNoStore() throws Exception {
		this.mockMvc.perform(get("/responseEntityCacheControlNoStore"))
				.andExpect(status().isOk())
				.andExpect(header().string(HttpHeaders.CACHE_CONTROL, "no-store"));
	}

	@Test
	void responseEntityCacheControlMaxAge() throws Exception {
		this.mockMvc.perform(get("/responseEntityCacheControlMaxAge"))
				.andExpect(status().isOk())
				.andExpect(header().string(HttpHeaders.CACHE_CONTROL, "max-age=600"));
	}

	@Test
	void isAnnotationPresent() {
		assertThat(HomeController.class.isAnnotationPresent(RestController.class)).isTrue();
		assertThat(HomeController.class.isAnnotationPresent(Controller.class)).isFalse();
	}

	@Test
	void printWithUtf8() throws Exception {
		this.mockMvc.perform(get("/map").header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)).andDo(print());
	}

}
