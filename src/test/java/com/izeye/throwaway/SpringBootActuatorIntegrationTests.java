package com.izeye.throwaway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Integration tests for Spring Boot Actuator.
 *
 * @author Johnny Lim
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootActuatorIntegrationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	@Test
	public void testActuator() {
		String response = this.restTemplate.getForObject("/actuator", String.class);
		JSONArray bootCuriesHrefs =
				JsonPath.parse(response).read("_links.curies[?(@.name == 'boot')].href");
		assertThat(bootCuriesHrefs).hasSize(1);
		assertThat(bootCuriesHrefs.get(0)).isEqualTo(
				"http://localhost:" + this.port + "/docs/#spring_boot_actuator__{rel}");
	}

}
