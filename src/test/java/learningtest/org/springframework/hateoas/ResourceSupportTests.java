package learningtest.org.springframework.hateoas;

import lombok.Data;
import org.junit.Test;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 12. 12..
 */
public class ResourceSupportTests {
	
	@Test
	public void test() {
		PersonResource resource = new PersonResource();
		resource.setFirstName("Johnny");
		resource.setLastName("Lim");
		
		Link selfLink = new Link("http://myhost/people");
		resource.add(selfLink);
		
		assertThat(resource.getId(), is(selfLink));
		assertThat(resource.getLink(Link.REL_SELF), is(selfLink));
	}
	
	@Data
	static class PersonResource extends ResourceSupport {
		private String firstName;
		private String lastName;
	}
	
}
