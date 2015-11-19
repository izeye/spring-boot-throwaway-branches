package com.izeye.throwaway.config;

import com.izeye.throwaway.Application;
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
 * Created by izeye on 15. 11. 19..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class ElasticsearchConfigurationTests {
	
	@Autowired
	Client client;
	
	@Test
	public void test() {
		SearchResponse response = this.client.prepareSearch("bank")
				.setQuery(QueryBuilders.matchAllQuery()).execute().actionGet();
		SearchHits hits = response.getHits();
		for (SearchHit hit : hits) {
			System.out.println(hit.getSource());
		}
	}
	
}
