package com.izeye.throwaway.config;

import com.izeye.throwaway.domain.Person;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by izeye on 16. 5. 21..
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class CacheConfigTests {
	
	@Autowired
	CacheManager cacheManager;
	
	@Test
	void test() {
		assertThat(this.cacheManager).isExactlyInstanceOf(EhCacheCacheManager.class);
		Cache cache = this.cacheManager.getCache("persons");
		cache.put(1L, new Person());
		
		Object nativeCache = cache.getNativeCache();
		assertThat(nativeCache).isInstanceOf(Ehcache.class);
		Ehcache ehcache = (Ehcache) nativeCache;
		assertThat(ehcache.getSize()).isEqualTo(1);
		
		// Wait for expiring the cache entry.
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// NOTE: But the size hasn't shrunk yet.
		assertThat(ehcache.getSize()).isEqualTo(1);
		
		// Confirm it's been evicted in the Spring Cache.
		Cache.ValueWrapper valueWrapper = cache.get(1L);
		assertThat(valueWrapper).isNull();

		// NOTE: After accessing it, now the size has shrunk.
		// i.e. Eviction has been triggered by accessing it. 
		assertThat(ehcache.getSize()).isEqualTo(0);
		
		// Confirm it's been evicted in the native cache (Ehcache).
		Element element = ehcache.get(1L);
		assertThat(element).isNull();
	}
	
}
