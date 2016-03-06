package com.izeye.throwaway.config;

import org.apache.ibatis.io.VFS;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by izeye on 16. 3. 6..
 */
public class SpringBootVFS extends VFS {
	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	protected List<String> list(URL url, String forPath) throws IOException {
		System.out.println("url: " + url);
		System.out.println("forPath: " + forPath);
		
		Resource[] resources = new PathMatchingResourcePatternResolver().getResources(
				forPath + "/**/*.class");
		System.out.println("resources: " + Arrays.asList(resources));
		
		return Arrays.asList(resources).stream().map(resource -> {
			try {
				URI uri = resource.getURI();
				System.out.println("uri: " + uri);
				
				String uriAsString = uri.toString();
				String finalValue = uriAsString.substring(uriAsString.indexOf(forPath));
				System.out.println("finalValue: " + finalValue);
				return finalValue;
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).collect(toList());
	}
	
}
