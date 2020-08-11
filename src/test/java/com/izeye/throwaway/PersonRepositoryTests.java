package com.izeye.throwaway;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link PersonRepository}.
 *
 * @author Johnny Lim
 */
@DataRedisTest
class PersonRepositoryTests {

    private final PersonRepository repository;

    PersonRepositoryTests(@Autowired PersonRepository repository) {
        this.repository = repository;
    }

    @Test
    void test() {
        Person person = new Person("1", "Johnny", "Lim");
        this.repository.save(person);

        Person found = this.repository.findById(person.getId()).get();
        assertThat(found.getFirstName()).isEqualTo(person.getFirstName());
        assertThat(found.getLastName()).isEqualTo(person.getLastName());

        person.setFirstName("John");
        this.repository.save(person);

        found = this.repository.findById(person.getId()).get();
        assertThat(found.getFirstName()).isEqualTo(person.getFirstName());
        assertThat(found.getLastName()).isEqualTo(person.getLastName());

        this.repository.deleteById(person.getId());
        assertThat(this.repository.findById(person.getId())).isEmpty();

        this.repository.deleteAll();

        Person person1 = new Person("1", "Johnny", "Lim");
        Person person2 = new Person("2", "John", "Lim");
        this.repository.save(person1);
        this.repository.save(person2);
        assertThat(this.repository.findAll()).hasSize(2);
    }

}
