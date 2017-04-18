package com.izeye.throwaway.config;

import com.izeye.throwaway.Application;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Tests for Elasticsearch configuration.
 *
 * @author Johnny Lim
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class ElasticsearchConfigurationTests {
	
	@Autowired
	Client client;
	
	@Test
	public void test() {
		SearchResponse response = this.client.prepareSearch("persons")
				.setQuery(QueryBuilders.matchAllQuery()).execute().actionGet();
		SearchHits hits = response.getHits();
		for (SearchHit hit : hits) {
			System.out.println(hit.getSource());
		}
	}

	@Test
	public void testIndex() {
		String json = "{firstName: \"Johnny\", lastName: \"Lim\", age: 20}";
		IndexResponse response = this.client.prepareIndex("persons", "persons")
				.setSource(json).get();
		System.out.println(response);
	}
	
}
