package learningtest.org.springframework.data.elasticsearch.core;

import com.izeye.throwaway.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.FacetedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;

/**
 * Created by izeye on 15. 11. 19..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class ElasticsearchTemplateTests {
	
	@Autowired
	ElasticsearchTemplate elasticsearchTemplate;
	
	@Test
	public void testQueryForPage() {
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				.withIndices("bank").withTypes("account").withQuery(matchAllQuery()).build();
		FacetedPage<Account> accounts = elasticsearchTemplate.queryForPage(searchQuery, Account.class);
		for (Account account : accounts) {
			System.out.println(account);
		}
	}
	
}
