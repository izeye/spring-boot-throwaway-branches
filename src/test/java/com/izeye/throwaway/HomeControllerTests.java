package com.izeye.throwaway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.izeye.throwaway.web.HomeController;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tests for {@link HomeController}.
 *
 * @author Johnny Lim
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HomeControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void responseEntityNoCacheControl() throws Exception {
		this.mockMvc.perform(get("/responseEntity"))
				.andExpect(status().isOk())
				.andExpect(header().doesNotExist(HttpHeaders.CACHE_CONTROL));
	}

	@Test
	public void responseEntityCacheControlEmpty() throws Exception {
		this.mockMvc.perform(get("/responseEntityCacheControlEmpty"))
				.andExpect(status().isOk())
				.andExpect(header().doesNotExist(HttpHeaders.CACHE_CONTROL));
	}

	@Test
	public void responseEntityCacheControlNoStore() throws Exception {
		this.mockMvc.perform(get("/responseEntityCacheControlNoStore"))
				.andExpect(status().isOk())
				.andExpect(header().string(HttpHeaders.CACHE_CONTROL, "no-store"));
	}

	@Test
	public void responseEntityCacheControlMaxAge() throws Exception {
		this.mockMvc.perform(get("/responseEntityCacheControlMaxAge"))
				.andExpect(status().isOk())
				.andExpect(header().string(HttpHeaders.CACHE_CONTROL, "max-age=600"));
	}

}
