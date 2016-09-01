package com.izeye.throwaway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.snippet.Attributes.key;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by izeye on 15. 10. 26..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs("build/generated-snippets")
public class PersonApiDocumentation {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void documentPersons() throws Exception {
		this.mockMvc.perform(get("/persons").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(document("persons",
						responseFields(
								fieldWithPath("[].id").description("ID")
										.attributes(key("deprecation").value("")),
								fieldWithPath("[].name.first_name").description("First name")
										.attributes(key("deprecation").value("")),
								fieldWithPath("[].name.last_name").description("Last name")
										.attributes(key("deprecation").value("")),
								fieldWithPath("[].age").description("Age")
										.attributes(key("deprecation").value("Age is not available now.")),
								fieldWithPath("[].created_time").description("Created time")
										.attributes(key("deprecation").value(""))
						)));
	}
	
}
