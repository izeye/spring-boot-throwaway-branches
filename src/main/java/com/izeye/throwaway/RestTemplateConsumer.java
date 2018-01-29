package com.izeye.throwaway;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;

@Service
public class RestTemplateConsumer {

	private RestTemplate restTemplate;

	public RestTemplateConsumer(RestTemplateBuilder restTemplateBuilder) {
		HttpComponentsClientHttpRequestFactory requestFactory = createSelfSignedTrustingRequestFactory();
		this.restTemplate = restTemplateBuilder.requestFactory(requestFactory).build();
	}

	public String get(String url) {
		return this.restTemplate.getForObject(url, String.class);
	}

	private HttpComponentsClientHttpRequestFactory createSelfSignedTrustingRequestFactory() {
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(createSelfSignedTrustingHttpClient());
		return requestFactory;
	}

	private HttpClient createSelfSignedTrustingHttpClient() {
		try {
			SSLContextBuilder sslContextBuilder = new SSLContextBuilder()
					.loadTrustMaterial(null, new TrustSelfSignedStrategy());
			SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(
					sslContextBuilder.build(), new NoopHostnameVerifier());
			return HttpClients.custom().setSSLSocketFactory(socketFactory).build();
		}
		catch (NoSuchAlgorithmException ex) {
			throw new RuntimeException(ex);
		}
		catch (KeyStoreException ex) {
			throw new RuntimeException(ex);
		}
		catch (KeyManagementException ex) {
			throw new RuntimeException(ex);
		}
	}

}
