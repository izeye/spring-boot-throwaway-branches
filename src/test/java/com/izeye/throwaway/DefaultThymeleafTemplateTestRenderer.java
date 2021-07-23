package com.izeye.throwaway;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletContext;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebExpressionContext;
import org.thymeleaf.spring5.expression.ThymeleafEvaluationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Default {@link ThymeleafTemplateTestRenderer}.
 *
 * @author Johnny Lim
 */
public class DefaultThymeleafTemplateTestRenderer implements ThymeleafTemplateTestRenderer, ApplicationContextAware {

    private final TemplateEngine engine;

    private volatile ApplicationContext applicationContext;

    public DefaultThymeleafTemplateTestRenderer(TemplateEngine engine) {
        this.engine = engine;
    }

    @Override
    public String render(String templateName, Map<String, Object> model) {
        Map<String, Object> mergedModel = new HashMap<>(model);

        ThymeleafEvaluationContext evaluationContext = new ThymeleafEvaluationContext(this.applicationContext, null);
        mergedModel.put(ThymeleafEvaluationContext.THYMELEAF_EVALUATION_CONTEXT_CONTEXT_VARIABLE_NAME, evaluationContext);

        WebExpressionContext context = new WebExpressionContext(this.engine.getConfiguration(), new MockHttpServletRequest(), new MockHttpServletResponse(), new MockServletContext(), null, mergedModel);

        return this.engine.process(templateName, context);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}
