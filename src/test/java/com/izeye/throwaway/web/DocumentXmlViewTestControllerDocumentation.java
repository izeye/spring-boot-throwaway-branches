package com.izeye.throwaway.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.relaxedResponseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Documentation for {@link DocumentXmlViewTestController}.
 *
 * @author Johnny Lim
 */
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs("build/generated-snippets")
class DocumentXmlViewTestControllerDocumentation {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void documentPersons() throws Exception {
        this.mockMvc.perform(get("/test/xml/persons").accept(MediaType.APPLICATION_XML))
                .andExpect(status().isOk())
                .andDo(document("persons-xml",
                        relaxedResponseFields(
								fieldWithPath("persons")
										.description("Persons").type(JsonFieldType.ARRAY),
                                fieldWithPath("persons/person")
                                        .description("Person").type(JsonFieldType.OBJECT),
                                fieldWithPath("persons/person/id")
                                        .description("ID for person").type(JsonFieldType.NUMBER),
                                fieldWithPath("persons/person/personName")
                                        .description("Name for person").type(JsonFieldType.OBJECT),
                                fieldWithPath("persons/person/personName/firstName")
                                        .description("First name for person").type(JsonFieldType.STRING),
                                fieldWithPath("persons/person/personName/lastName")
                                        .description("Last name for person").type(JsonFieldType.STRING),
                                fieldWithPath("persons/person/age")
                                        .description("Age for person").type(JsonFieldType.NUMBER)
                        )));
    }

}
