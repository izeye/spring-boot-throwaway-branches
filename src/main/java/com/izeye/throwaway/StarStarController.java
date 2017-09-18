package com.izeye.throwaway;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * {@link Controller} handling {@code /**}.
 *
 * @author Johnny Lim
 */
@Controller
public class StarStarController {

	// NOTE: Static resources won't work with {@code /**} path.
	@RequestMapping(path = "/**")
	@ResponseBody
	public String getAny(HttpServletRequest request) {
		return request.toString();
	}

}
