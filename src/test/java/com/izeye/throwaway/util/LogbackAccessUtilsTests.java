package com.izeye.throwaway.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link LogbackAccessUtils}.
 *
 * @author Johnny Lim
 */
class LogbackAccessUtilsTests {

    @Test
    void convertRequestLogToCurl() {
        String expected = "curl -s -X POST \"http://localhost:8080/persons/echo\" \\\n" +
                "  -H \"host: localhost:8080\" \\\n" +
                "  -H \"user-agent: curl/7.64.1\" \\\n" +
                "  -H \"accept: */*\" \\\n" +
                "  -H \"content-type: application/json\" \\\n" +
                "  -H \"my-header: Johnny\" \\\n" +
                "  -H \"content-length: 50\" \\\n" +
                " --data '{\n" +
                "  \"firstName\": \"Johnny\",\n" +
                "  \"secondName\": \"Lim\"\n" +
                "}'";

        String requestLogLines = "POST /persons/echo HTTP/1.1\n" +
                "host: localhost:8080\n" +
                "user-agent: curl/7.64.1\n" +
                "accept: */*\n" +
                "content-type: application/json\n" +
                "my-header: Johnny\n" +
                "content-length: 50\n" +
                "\n" +
                "{\n" +
                "  \"firstName\": \"Johnny\",\n" +
                "  \"secondName\": \"Lim\"\n" +
                "}";

        String curl = LogbackAccessUtils.convertRequestLogToCurl(requestLogLines);
        System.out.println(curl);

        assertThat(curl).isEqualTo(expected);
    }

}