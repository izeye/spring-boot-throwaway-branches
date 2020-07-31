package com.izeye.throwaway.person.web;

import com.izeye.throwaway.person.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO for {@link Person}.
 *
 * @author Johnny Lim
 */
@Data
@AllArgsConstructor
public class PersonDTO {

    private final String firstName;
    private final String lastName;

}
