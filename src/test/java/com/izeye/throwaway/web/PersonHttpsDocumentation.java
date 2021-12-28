package com.izeye.throwaway.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.cli.CliDocumentation.curlRequest;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Documentation for {@link PersonController}.
 *
 * @author Johnny Lim
 */
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs(uriScheme = "https")
class PersonHttpsDocumentation {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void documentPersons() throws Exception {
        this.mockMvc.perform(get("/persons/{id}", "1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andDo(document("persons-https",
                        pathParameters(parameterWithName("id").description("ID")),
                        responseFields(
                                fieldWithPath("id").description("ID"),
                                fieldWithPath("firstName").description("First name"),
                                fieldWithPath("lastName").description("Last name"))));
    }

}
