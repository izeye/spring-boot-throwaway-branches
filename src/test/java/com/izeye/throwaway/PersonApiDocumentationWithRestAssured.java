package com.izeye.throwaway;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.restassured.RestAssuredRestDocumentation.document;
import static org.springframework.restdocs.restassured.RestAssuredRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.snippet.Attributes.key;

/**
 * Created by izeye on 16. 3. 11..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest(randomPort = true)
public class PersonApiDocumentationWithRestAssured {

	@Rule
	public final JUnitRestDocumentation restDocumentation
			= new JUnitRestDocumentation("build/generated-snippets");
	
	private RequestSpecification documentationSpec;
	
	@Value("${local.server.port}")
	int port;

	@Before
	public void setUp() {
		this.documentationSpec = new RequestSpecBuilder()
				.addFilter(documentationConfiguration(restDocumentation)).build();
	}

	@Test
	public void documentPersons() throws Exception {
		given(this.documentationSpec).accept(ContentType.JSON).filter(document("persons_with_rest_assured",
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
				)))
				.when().port(this.port).get("/persons")
				.then().assertThat().statusCode(is(200));
	}
	
}
