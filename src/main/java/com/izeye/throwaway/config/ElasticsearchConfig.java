package com.izeye.throwaway.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.sniff.Sniffer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * {@link Configuration} for Elasticsearch.
 *
 * @author Johnny Lim
 */
@Configuration
public class ElasticsearchConfig {

    @Bean
    public Sniffer sniffer(RestHighLevelClient restHighLevelClient) {
        return Sniffer.builder(restHighLevelClient.getLowLevelClient()).build();
    }

}
