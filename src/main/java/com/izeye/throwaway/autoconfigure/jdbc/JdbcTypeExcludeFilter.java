package com.izeye.throwaway.autoconfigure.jdbc;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;

import org.springframework.boot.test.autoconfigure.filter.AnnotationCustomizableTypeExcludeFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;

/**
 * Type excluding filter for JDBC.
 *
 * @author Johnny Lim
 */
class JdbcTypeExcludeFilter extends AnnotationCustomizableTypeExcludeFilter {

	private final JdbcTest annotation;

	JdbcTypeExcludeFilter(Class<?> testClass) {
		this.annotation = AnnotatedElementUtils.getMergedAnnotation(testClass, JdbcTest.class);
	}

	@Override
	protected boolean hasAnnotation() {
		return this.annotation != null;
	}

	@Override
	protected ComponentScan.Filter[] getFilters(FilterType type) {
		switch (type) {
			case INCLUDE:
				return this.annotation.includeFilters();

			case EXCLUDE:
				return this.annotation.excludeFilters();

			default:
				throw new IllegalArgumentException("Unsupported type: " + type);
		}
	}

	@Override
	protected boolean isUseDefaultFilters() {
		return this.annotation.useDefaultFilters();
	}

	@Override
	protected boolean defaultInclude(
			MetadataReader metadataReader,
			MetadataReaderFactory metadataReaderFactory) throws IOException {
		return false;
	}

	@Override
	protected Set<Class<?>> getDefaultIncludes() {
		return Collections.emptySet();
	}

}
