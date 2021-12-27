package com.izeye.throwaway.config;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for Apache Commons Pool.
 *
 * @author Johnny Lim
 */
@Configuration
public class ApacheCommonsPoolConfig {

    // This triggers the following exception:
    // javax.management.InstanceAlreadyExistsException: MXBean already registered with name org.apache.commons.pool2:type=GenericObjectPool,name=pool
    //
    // GenericObjectPool instantiation registers MXBean, and then Spring MBeanExporter also registers MXBean.
    @Bean
    public GenericObjectPool<String> genericObjectPool() {
        GenericObjectPool<String> genericObjectPool = new GenericObjectPool<>(new BasePooledObjectFactory<String>() {

            @Override
            public String create() {
                return "test";
            }

            @Override
            public PooledObject<String> wrap(String obj) {
                return new DefaultPooledObject<>(obj);
            }

        });
        return genericObjectPool;
    }

}
