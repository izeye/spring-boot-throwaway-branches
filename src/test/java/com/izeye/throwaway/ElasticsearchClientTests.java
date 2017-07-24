package com.izeye.throwaway;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.search.SearchHit;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;
import static org.elasticsearch.index.query.QueryBuilders.existsQuery;
import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchClientTests {

	@Autowired
	private Client client;

	@Test
	public void testPrepareIndex() throws IOException {
		Map<String, String> name = new HashMap<>();
		name.put("firstName", "Johnny");
		name.put("lastName", "Lim");

		Map<String, Object> info = new HashMap<>();
		info.put("nested", new HashMap<String, String>());

		IndexResponse indexResponse = this.client.prepareIndex("persons", "persons")
				.setSource(jsonBuilder()
						.startObject()
						.field("name", name)
						.field("info", info)
						.endObject()).get();
		System.out.println(indexResponse);
	}

	@Test
	public void testPrepareSearchMatchAll() {
		SearchResponse response = this.client.prepareSearch("persons").setQuery(matchAllQuery()).get();
		for (SearchHit hit : response.getHits().getHits()) {
			System.out.println(hit.getSource());
		}
	}

	@Test
	public void testPrepareSearchExistsQueryName() {
		SearchResponse response = this.client.prepareSearch("persons").setQuery(existsQuery("name")).get();
		for (SearchHit hit : response.getHits().getHits()) {
			System.out.println(hit.getSource());
		}
	}

	// NOTE: Object having an empty object is the same as null in the perspective of indexing.
	@Test
	public void testPrepareSearchExistsQueryInfo() {
		SearchResponse response = this.client.prepareSearch("persons").setQuery(existsQuery("info")).get();
		System.out.println(response);
		for (SearchHit hit : response.getHits().getHits()) {
			System.out.println(hit.getSource());
		}
	}

	// NOTE: Empty object is the same as null in the perspective of indexing.
	@Test
	public void testPrepareSearchExistsQueryInfoNested() {
		SearchResponse response = this.client.prepareSearch("persons").setQuery(existsQuery("info.nested")).get();
		System.out.println(response);
		for (SearchHit hit : response.getHits().getHits()) {
			System.out.println(hit.getSource());
		}
	}

}
