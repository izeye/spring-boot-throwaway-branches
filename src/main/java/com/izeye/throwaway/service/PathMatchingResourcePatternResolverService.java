package com.izeye.throwaway.service;

import java.io.IOException;
import java.net.URI;
import java.net.URL;

import javax.annotation.PostConstruct;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;

/**
 * Service using {@link PathMatchingResourcePatternResolver}.
 *
 * @author Johnny Lim
 */
@Service
public class PathMatchingResourcePatternResolverService {

	@PostConstruct
	public void init() throws IOException {
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource[] templateResources = resolver.getResources("classpath:templates/**/*.html");
		for (Resource templateResource : templateResources) {
			URI uri = templateResource.getURI();
			String uriPath = uri.getPath();
			URL url = templateResource.getURL();
			String urlPath = url.getPath();
			System.out.println("templateResource: " + templateResource);
			System.out.println("uri: " + uri);
			System.out.println("uriPath: " + uriPath);
			System.out.println("url: " + url);
			System.out.println("urlPath: " + urlPath);
		}
	}

}
