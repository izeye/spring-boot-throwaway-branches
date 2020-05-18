package com.izeye.throwaway.support.profile;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * {@link Aspect} for profiling.
 *
 * @author Johnny Lim
 */
@Component
@Aspect
@Slf4j
public class ProfilingAspect {

	@Around("execution(* com.izeye.throwaway..*.*(..))")
	public Object execute(ProceedingJoinPoint pjp) throws Throwable {
		long startTimeMillis = System.currentTimeMillis();
		try {
			return pjp.proceed();
		}
		finally {
			log.info("Elapsed time for executing {}.{}(): {} ms",
					pjp.getTarget().getClass().getSimpleName(),
					pjp.getSignature().getName(),
					System.currentTimeMillis() - startTimeMillis);
		}
	}

}
