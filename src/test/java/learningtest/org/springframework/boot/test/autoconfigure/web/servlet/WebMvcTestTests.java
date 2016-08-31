package learningtest.org.springframework.boot.test.autoconfigure.web.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tests for {@link WebMvcTest}.
 *
 * @author Johnny Lim
 */
@RunWith(SpringRunner.class)
@WebMvcTest(WebMvcTestTests.UserVehicleController.class)
public class WebMvcTestTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private UserVehicleService userVehicleService;

	@Test
	public void test() throws Exception {
		String username = "sboot";
		given(this.userVehicleService.getVehicleDetails(username))
				.willReturn(new VehicleDetails("Honda", "Civic"));
		this.mvc.perform(get("/sboot/vehicle").accept(MediaType.TEXT_PLAIN))
				.andExpect(status().isOk()).andExpect(content().string("Honda Civic"));
	}

	@Data
	@AllArgsConstructor
	static class VehicleDetails {

		private String company;
		private String model;

		@Override
		public String toString() {
			return company + " " + model;
		}

	}

	interface UserVehicleService {

		VehicleDetails getVehicleDetails(String username);

	}

	@Service
	static class DefaultUserVehicleService implements UserVehicleService {

		@Override
		public VehicleDetails getVehicleDetails(String username) {
			throw new RuntimeException("Intentional error.");
		}

	}

	@RestController
	static class UserVehicleController {

		@Autowired
		private UserVehicleService userVehicleService;

		@GetMapping(path = "/{username}/vehicle")
		public String getVehicle(@PathVariable String username) {
			return this.userVehicleService.getVehicleDetails(username).toString();
		}

	}

	@SpringBootApplication
	static class Application {
	}

}
