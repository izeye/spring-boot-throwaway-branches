package com.izeye.throwaway.config;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by izeye on 16. 6. 19..
 */
@Configuration
@EntityScan("com.izeye.common")
public class PersistenceConfig {
}
