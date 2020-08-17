package com.izeye.throwaway.person.service;

import java.util.List;
import com.izeye.throwaway.person.domain.Item;
import com.izeye.throwaway.person.domain.Person;
import com.izeye.throwaway.person.domain.PersonWithItem;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Remote service for {@link Person}.
 *
 * @author Johnny Lim
 */
public interface RemotePersonService {

	Mono<Person> getPerson(Long id);

	Mono<Person> getOtherPerson(Long id);

	Mono<Item> getItem(Long id);

	Flux<Person> getPersons(List<Long> ids);

	Flux<Person> getPersonAndOtherPerson(Long id);

	Mono<PersonWithItem> getPersonWithItem(Long userId, Long itemId);

}
