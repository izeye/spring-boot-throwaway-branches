package com.izeye.throwaway.service;

import java.lang.annotation.*;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * {@link Lazy} version of {@link Service}.
 *
 * @author Johnny Lim
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
@Lazy
public @interface LazyService {
}
