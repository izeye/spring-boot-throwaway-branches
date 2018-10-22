package com.izeye.throwaway.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Sample prototype-scoped bean.
 *
 * @author Johnny Lim
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SamplePrototypeScopeBean {
}
