package com.izeye.throwaway;

import java.util.Map;

/**
 * Test renderer for Thymeleaf templates.
 *
 * @author Johnny Lim
 */
public interface ThymeleafTemplateTestRenderer {

    String render(String templateName, Map<String, Object> model);

}
