package com.izeye.throwaway;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.dialect.SpringStandardDialect;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.util.Map;

/**
 * Default {@link ThymeleafTemplateVerifier}.
 *
 * @author Johnny Lim
 */
public class DefaultThymeleafTemplateVerifier implements ThymeleafTemplateVerifier {

    private final TemplateEngine engine;

    public DefaultThymeleafTemplateVerifier() {
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);

        this.engine = new TemplateEngine();
        this.engine.setTemplateResolver(resolver);
        this.engine.setDialect(new SpringStandardDialect());
    }

    @Override
    public void verify(String templateName, Map<String, Object> model) {
        Context context = modelToContext(model);
        this.engine.process(templateName, context);
    }

    private Context modelToContext(Map<String, Object> model) {
        Context context = new Context();
        for (Map.Entry<String, Object> attribute : model.entrySet()) {
            context.setVariable(attribute.getKey(), attribute.getValue());
        }
        return context;
    }

}
