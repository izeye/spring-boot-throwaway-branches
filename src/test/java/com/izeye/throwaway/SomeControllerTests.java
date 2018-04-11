package com.izeye.throwaway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tests for {@link SomeController}.
 *
 * @author Johnny Lim
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SomeControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void test() throws Exception {
		SomeRequest request = new SomeRequest();
		request.setId("id");
		SomeObject object = new SomeObject();
		object.setName("name");
		request.setObject(object);
		String requestJson = this.objectMapper.writeValueAsString(request);
		this.mockMvc.perform(get("/some").contentType(MediaType.APPLICATION_JSON).content(requestJson))
				.andExpect(status().isOk())
				.andExpect(content().string("{\"id\":\"id\"}"));
	}

	@Test
	public void testWhenInvalidTypeShouldReturnBadRequest() throws Exception {
		String requestJson = "{\"id\":\"id\", \"object\":\"invalidTypeValue\"}";
		this.mockMvc.perform(get("/some").contentType(MediaType.APPLICATION_JSON).content(requestJson))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void testWhenUnsupportedHttpMethodShouldReturnBadRequest() throws Exception {
		SomeRequest request = new SomeRequest();
		request.setId("id");
		SomeObject object = new SomeObject();
		object.setName("name");
		request.setObject(object);
		String requestJson = this.objectMapper.writeValueAsString(request);
		this.mockMvc.perform(post("/some").contentType(MediaType.APPLICATION_JSON).content(requestJson))
				.andExpect(status().isBadRequest());
	}

}
