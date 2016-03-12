package com.izeye.throwaway.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.izeye.throwaway.Application;
import com.izeye.throwaway.Person;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by izeye on 15. 11. 19..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class ElasticsearchConfigurationTests {
	
	@Autowired
	Client client;
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	@Before
	public void setUp() {
		this.objectMapper = new ObjectMapper();
		this.objectMapper.setPropertyNamingStrategy(
				PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
	}
	
	@Test
	public void test() {
		Person person = new Person();
		person.setId(1234L);
		person.setFirstName("Johnny");
		person.setLastName("Lim");
		person.setAge(36);
		
		try {
			String json = this.objectMapper.writeValueAsString(person);
			System.out.println(json);

			IndexResponse response = this.client.prepareIndex("person", "person", person.getId().toString())
					.setSource(json).get();
			System.out.println(response);
		} catch (JsonProcessingException ex) {
			throw new RuntimeException(ex);
		}
		
		SearchResponse response = this.client.prepareSearch("person")
				.setQuery(QueryBuilders.matchAllQuery()).execute().actionGet();
		SearchHits hits = response.getHits();
		for (SearchHit hit : hits) {
			System.out.println(hit.getSource());
		}
	}
	
}
