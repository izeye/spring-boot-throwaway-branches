package learningtest.org.springframework.cache;

import com.izeye.throwaway.Application;
import com.izeye.throwaway.domain.Person;
import com.izeye.throwaway.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by izeye on 16. 4. 2..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class CacheManagerTests {
	
	@Autowired
	CacheManager cacheManager;
	
	@Autowired
	PersonService personService;
	
	@Test
	public void testCacheNames() {
		System.out.println(this.cacheManager);
		
		// ConcurrentMapCacheManager creates a cache after accessing @Cacheable method.
		// However, EhCacheCacheManager creates a cache without accessing @Cacheable method
		// due to its configuration file (ehcache.xml).
//		personService.getPersonWithInterfaceCacheable();
		
		Collection<String> cacheNames = this.cacheManager.getCacheNames();
		System.out.println("cacheNames: " + cacheNames);
		for (String cacheName : cacheNames) {
			Cache cache = this.cacheManager.getCache(cacheName);
			System.out.println(cache);
		}
	}
	
	@Test
	public void testPutAndGet() {
		long id = 1L;
		
		Person person = new Person();
		person.setId(id);

		Cache cache = this.cacheManager.getCache("manualPersonCache");
		System.out.println(cache);
		
		cache.put(person.getId(), person);
		assertThat(cache.get(id, Person.class)).isEqualTo(person);
	}
	
}
