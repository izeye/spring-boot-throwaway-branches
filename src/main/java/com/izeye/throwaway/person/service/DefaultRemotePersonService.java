package com.izeye.throwaway.person.service;

import java.util.Comparator;
import java.util.List;
import org.springframework.web.reactive.function.client.WebClient;
import com.izeye.throwaway.person.domain.Item;
import com.izeye.throwaway.person.domain.Person;
import com.izeye.throwaway.person.domain.PersonWithItem;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * Default {@link RemotePersonService}.
 *
 * @author Johnny Lim
 */
@Slf4j
public class DefaultRemotePersonService implements RemotePersonService {

	private final WebClient webClient;

	public DefaultRemotePersonService(String baseUrl) {
		this.webClient = WebClient.create(baseUrl);
	}

	@Override
	public Mono<Person> getPerson(Long id) {
		log.info("Calling getPerson({})", id);
		return this.webClient.get()
				.uri("/persons/{id}", id)
				.retrieve()
				.bodyToMono(Person.class);
	}

	@Override
	public Mono<Person> getOtherPerson(Long id) {
		return this.webClient.get()
				.uri("/otherPersons/{id}", id)
				.retrieve()
				.bodyToMono(Person.class);
	}

	@Override
	public Mono<Item> getItem(Long id) {
		return this.webClient.get()
				.uri("/items/{id}", id)
				.retrieve()
				.bodyToMono(Item.class);
	}

	@Override
	public Flux<Person> getPersons(List<Long> ids) {
		return Flux.fromIterable(ids)
				.parallel()
				.runOn(Schedulers.boundedElastic())
				.flatMap(this::getPerson)
				.ordered(Comparator.comparing(Person::getId));
	}

	@Override
	public Flux<Person> getPersonAndOtherPerson(Long id) {
		return Flux.merge(getPerson(id), getOtherPerson(id))
				.parallel()
				.runOn(Schedulers.boundedElastic())
				.ordered(Comparator.comparing(Person::getId));
	}

	@Override
	public Mono<PersonWithItem> getPersonWithItem(Long userId, Long itemId) {
		Mono<Person> person = getPerson(userId).subscribeOn(Schedulers.boundedElastic());
		Mono<Item> item = getItem(itemId).subscribeOn(Schedulers.boundedElastic());
		return Mono.zip(person, item, PersonWithItem::new);
	}

}
