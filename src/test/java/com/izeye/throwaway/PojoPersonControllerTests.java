package com.izeye.throwaway;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.hateoas.Link;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringEndsWith.endsWith;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by izeye on 15. 12. 12..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebAppConfiguration
public class PojoPersonControllerTests {
	
	@Test
	public void test() {
		Link link = linkTo(PojoPersonController.class).withRel("persons");
		assertThat(link.getRel(), is("persons"));
		assertThat(link.getHref(), endsWith("/pojo-persons"));

		PoJoPerson person = new PoJoPerson(1L, "Johnny", "Lim");

		link = linkTo(PojoPersonController.class).slash(person.getId()).withSelfRel();
		assertThat(link.getRel(), is(Link.REL_SELF));
		assertThat(link.getHref(), endsWith("/pojo-persons/1"));
	}
	
}
