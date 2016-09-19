package com.izeye.throwaway.config;

import org.springframework.beans.factory.FactoryBean;

import lombok.Data;

/**
 * {@link FactoryBean} for {@link TransportClient}.
 *
 * @author Johnny Lim
 */
@Data
public class TransportClientFactoryBean implements FactoryBean<TransportClient> {

	private String clusterName;

	@Override
	public TransportClient getObject() throws Exception {
		TransportClient transportClient = new TransportClient();
		transportClient.setClusterName(this.clusterName);
		return transportClient;
	}

	@Override
	public Class<?> getObjectType() {
		return TransportClient.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
