package com.izeye.throwaway;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by izeye on 16. 2. 18..
 */
@Configuration
public class ElasticsearchConfig {
	
	@Bean
	public Client elasticsearchClient() {
//		TransportClient client = new TransportClient();
//		client.addTransportAddress(new InetSocketTransportAddress("localhost", 9300));
//		return client;
		
		TransportClient client = TransportClient.builder().build();
		try {
			client.addTransportAddress(
					new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
		} catch (UnknownHostException ex) {
			throw new RuntimeException(ex);
		}
		return client;
	}
	
}
