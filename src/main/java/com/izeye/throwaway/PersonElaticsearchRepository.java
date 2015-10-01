package com.izeye.throwaway;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by izeye on 15. 10. 1..
 */
public interface PersonElaticsearchRepository
		extends ElasticsearchRepository<Person, Long> {
}
