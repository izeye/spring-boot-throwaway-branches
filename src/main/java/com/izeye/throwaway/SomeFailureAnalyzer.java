package com.izeye.throwaway;

import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

/**
 * {@link AbstractFailureAnalyzer} for {@link SomeException}.
 *
 * @author Johnny Lim
 */
class SomeFailureAnalyzer extends AbstractFailureAnalyzer<SomeException> {

	@Override
	protected FailureAnalysis analyze(Throwable rootFailure, SomeException cause) {
		return new FailureAnalysis("Some description", "Some action", cause);
	}

}
