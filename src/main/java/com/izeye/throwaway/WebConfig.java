package com.izeye.throwaway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.HttpEncodingProperties;
import org.springframework.boot.context.web.OrderedCharacterEncodingFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

/**
 * Created by izeye on 15. 10. 7..
 */
@Configuration
public class WebConfig {

	@Autowired
	private HttpEncodingProperties httpEncodingProperties;

	// NOTE:
	// This is a workaround for a bug (gh-3912) on Spring Boot 1.3.0.M5.
	// You can drop this code after upgrading Spring Boot 1.3.0.RC1.
	@Bean
	public OrderedCharacterEncodingFilter characterEncodingFilter() {
		OrderedCharacterEncodingFilter filter = new OrderedCharacterEncodingFilter();
		filter.setEncoding(this.httpEncodingProperties.getCharset().name());
		filter.setForceEncoding(this.httpEncodingProperties.isForce());
		filter.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return filter;
	}
	
}
