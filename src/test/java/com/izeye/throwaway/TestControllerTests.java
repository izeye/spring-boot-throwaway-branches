package com.izeye.throwaway;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tests for {@link TestController}.
 *
 * @author Johnny Lim
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testNullField() throws Exception {
		this.mockMvc.perform(get("/test/test-null-field"))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("First name: \"\"")));
	}

	@Test
	public void testNullModelAndView() throws Exception {
		this.mockMvc.perform(get("/test/null-model-and-view"))
				.andExpect(status().isOk())
				.andExpect(content().string(""));
	}

}
