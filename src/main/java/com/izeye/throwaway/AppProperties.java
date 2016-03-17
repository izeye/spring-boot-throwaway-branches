package com.izeye.throwaway;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by izeye on 16. 3. 17..
 */
@ConfigurationProperties(prefix = "app")
@Data
public class AppProperties {
	
	private String someProperty;
	
}
