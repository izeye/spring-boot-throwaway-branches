package com.izeye.throwaway;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Some {@link RuntimeException}.
 *
 * @author Johnny Lim
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class SomeException extends RuntimeException {

	private String something;

}
