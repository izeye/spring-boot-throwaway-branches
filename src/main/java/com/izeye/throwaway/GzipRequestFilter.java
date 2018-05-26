package com.izeye.throwaway;

import java.io.IOException;
import java.util.zip.GZIPInputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ReadListener;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * {@link Filter} to support gzip content encoding for requests.
 *
 * @author Johnny Lim
 */
@WebFilter
public class GzipRequestFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request = getServletRequest(request);
		chain.doFilter(request, response);
	}

	private ServletRequest getServletRequest(ServletRequest request) {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		if ("gzip".equals(httpServletRequest.getHeader("Content-Encoding"))) {
			return new GzipServletRequestWrapper(httpServletRequest);
		}
		return request;
	}

	@Override
	public void destroy() {
	}

	private static class GzipServletRequestWrapper extends HttpServletRequestWrapper {

		public GzipServletRequestWrapper(HttpServletRequest request) {
			super(request);
		}

		@Override
		public ServletInputStream getInputStream() throws IOException {
			return new GZIPServletInputStream(super.getInputStream());
		}

	}

	private static class GZIPServletInputStream extends ServletInputStream {

		private final ServletInputStream servletInputStream;

		private final GZIPInputStream gzipInputStream;

		public GZIPServletInputStream(ServletInputStream servletInputStream) throws IOException {
			this.servletInputStream = servletInputStream;

			this.gzipInputStream = new GZIPInputStream(servletInputStream);
		}

		@Override
		public int read() throws IOException {
			return this.gzipInputStream.read();
		}

		@Override
		public boolean isFinished() {
			return this.servletInputStream.isFinished();
		}

		@Override
		public boolean isReady() {
			return this.servletInputStream.isReady();
		}

		@Override
		public void setReadListener(ReadListener listener) {
			this.servletInputStream.setReadListener(listener);
		}

	}

}
