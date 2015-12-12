package learningtest.org.springframework.hateoas;

import org.junit.Test;
import org.springframework.hateoas.Link;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 12. 12..
 */
public class LinkTests {
	
	@Test
	public void test() {
		Link link = new Link("http://localhost:8080/something");
		assertThat(link.getHref(), is("http://localhost:8080/something"));
		assertThat(link.getRel(), is(Link.REL_SELF));
		
		link = new Link("http://localhost:8080/something", "my-rel");
		assertThat(link.getHref(), is("http://localhost:8080/something"));
		assertThat(link.getRel(), is("my-rel"));
	}
	
}
