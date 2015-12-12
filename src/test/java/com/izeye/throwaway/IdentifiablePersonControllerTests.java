package com.izeye.throwaway;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.hateoas.Link;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.lang.reflect.Method;
import java.net.URI;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringEndsWith.endsWith;
import static org.springframework.hateoas.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by izeye on 15. 12. 12..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebAppConfiguration
public class IdentifiablePersonControllerTests {

	@Test
	public void test() {
		Link link = linkTo(IdentifiablePersonController.class).withRel("persons");
		assertThat(link.getRel(), is("persons"));
		assertThat(link.getHref(), endsWith("/identifiable-persons"));

		IdentifiablePerson person = new IdentifiablePerson(1L, "Johnny", "Lim");

		link = linkTo(IdentifiablePersonController.class).slash(person).withSelfRel();
		assertThat(link.getRel(), is(Link.REL_SELF));
		assertThat(link.getHref(), endsWith("/identifiable-persons/1"));

		URI uri = linkTo(IdentifiablePersonController.class).slash(person).toUri();
		System.out.println(uri);
	}
	
	@Test
	public void testMethod() throws NoSuchMethodException {
		Method method = IdentifiablePersonController.class.getMethod("show", long.class);
		Link link = linkTo(method, 2L).withSelfRel();
		assertThat(link.getHref(), endsWith("/identifiable-persons/2"));
	}
	
	@Test
	public void testMethodOn() {
		Link link = linkTo(methodOn(IdentifiablePersonController.class).show(2L)).withSelfRel();
		assertThat(link.getHref(), endsWith(("/identifiable-persons/2")));
	}
	
}
