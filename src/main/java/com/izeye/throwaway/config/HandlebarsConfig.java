package com.izeye.throwaway.config;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.cache.GuavaTemplateCache;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;
import com.github.jknack.handlebars.io.TemplateSource;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * Configuration for Handlebars.java.
 *
 * @author Johnny Lim
 */
@Configuration
public class HandlebarsConfig {

    @Bean
    public Handlebars handlebars() {
        TemplateLoader templateLoader = new ClassPathTemplateLoader("/templates", ".hbs");
        Cache<TemplateSource, Template> templateCache = CacheBuilder.newBuilder()
                .expireAfterWrite(10, TimeUnit.MINUTES).maximumSize(1000).build();
        return new Handlebars(templateLoader).with(new GuavaTemplateCache(templateCache));
    }

}
