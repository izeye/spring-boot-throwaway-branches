package com.izeye.throwaway;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.snippet.Attributes.key;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by izeye on 15. 10. 26..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebAppConfiguration
public class PersonApiDocumentation {
	
	@Rule
	public final JUnitRestDocumentation restDocumentation
			= new JUnitRestDocumentation("build/generated-snippets");
	
	@Autowired
	WebApplicationContext context;
	
	MockMvc mockMvc;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
				.apply(documentationConfiguration(this.restDocumentation)).build();
	}
	
	@Test
	public void documentPersons() throws Exception {
		this.mockMvc.perform(get("/persons").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(document("persons",
						responseFields(
								fieldWithPath("[].id").description("ID")
										.attributes(key("deprecation").value("")),
								fieldWithPath("[].first_name").description("First name")
										.attributes(key("deprecation").value("")),
								fieldWithPath("[].last_name").description("Last name")
										.attributes(key("deprecation").value("")),
								fieldWithPath("[].age").description("Age")
										.attributes(key("deprecation").value("Age is not available now.")),
								fieldWithPath("[].created_time").description("Created time")
										.attributes(key("deprecation").value(""))
						)));
	}
	
}
