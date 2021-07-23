package com.izeye.throwaway;

import java.util.Map;

/**
 * Verifier for Thymeleaf templates.
 *
 * @author Johnny Lim
 */
public interface ThymeleafTemplateVerifier {

    void verify(String templateName, Map<String, Object> model);

}
