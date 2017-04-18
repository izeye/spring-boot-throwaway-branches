package com.izeye.throwaway.support.elasticsearch;

import lombok.Data;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Set;

/**
 * Created by izeye on 15. 11. 19..
 */
@Data
public class TransportClientFactoryBean implements FactoryBean<TransportClient>, InitializingBean, DisposableBean {
	
	private static final char COLON = ':';

	private String clusterName = "elasticsearch";
	private String clusterNodes = "127.0.0.1:9300";
	
	private TransportClient client;
	
	@Override
	public void destroy() throws Exception {
		if (this.client != null) {
			this.client.close();
		}
	}

	@Override
	public TransportClient getObject() throws Exception {
		return this.client;
	}

	@Override
	public Class<?> getObjectType() {
		return TransportClient.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		createTransportClient();
	}

	private void createTransportClient() {
		this.client = TransportClient.builder().settings(settings()).build();
		Assert.hasText(clusterNodes, "clusterNodes must have a value.");
		Set<String> nodes = StringUtils.commaDelimitedListToSet(clusterNodes);
		for (String node : nodes) {
			int index = node.indexOf(COLON);
			Assert.isTrue(index >= 0, "':' is missing in a cluster node value: " + node);
			String hostname = node.substring(0, index);
			int port = Integer.parseInt(node.substring(index + 1));
			try {
				this.client.addTransportAddress(new InetSocketTransportAddress(
						InetAddress.getByName(hostname), port));
			}
			catch (UnknownHostException ex) {
				throw new RuntimeException(ex);
			}
		}
	}
	
	private Settings settings() {
		return Settings.settingsBuilder()
				.put("cluster.name", clusterName).build();
	}
	
}
