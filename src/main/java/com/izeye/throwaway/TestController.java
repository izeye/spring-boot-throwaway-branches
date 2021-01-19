package com.izeye.throwaway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * {@link RestController} for testing.
 *
 * @author Johnny Lim
 */
@RequestMapping(path = "/test")
@RestController
public class TestController {

    @GetMapping(path = "/reject-header-value")
    public String get(HttpServletRequest request) {
        return request.getHeader("My-Header");
    }

}
