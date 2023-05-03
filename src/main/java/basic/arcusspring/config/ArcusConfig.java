package basic.arcusspring.config;

import com.navercorp.arcus.spring.cache.ArcusCacheConfiguration;
import com.navercorp.arcus.spring.cache.ArcusCacheManager;
import com.navercorp.arcus.spring.cache.StringKeyGenerator;
import net.spy.memcached.ConnectionFactoryBuilder;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableCaching
public class ArcusConfig extends CachingConfigurerSupport{
    private static String ADMIN_ADDRESS = "127.0.0.1:2191";
    private static String SERVICE_CODE = "brido";
    private static int POOL_SIZE = 2;

    @Bean
    @Override
    public KeyGenerator keyGenerator() {
        return new StringKeyGenerator();
    }

    @Bean
    @Override
    public CacheManager cacheManager() {
        return new ArcusCacheManager(
                ADMIN_ADDRESS,
                SERVICE_CODE,
                new ConnectionFactoryBuilder(),
                POOL_SIZE,
                /* default cache configuration (missing cache) */
                defaultCacheConfig(),
                /* a map of cache configuration (key=cache name, value=cache configuration) */
                initialCacheConfig()
        );
    }

    @Bean
    public ArcusCacheConfiguration defaultCacheConfig() {
        ArcusCacheConfiguration defaultCacheConfig = new ArcusCacheConfiguration();
        defaultCacheConfig.setPrefix("DEFAULT");
        defaultCacheConfig.setExpireSeconds(60);
        defaultCacheConfig.setTimeoutMilliSeconds(800);
        return defaultCacheConfig;
    }

    @Bean
    public Map<String, ArcusCacheConfiguration> initialCacheConfig() {
        Map<String, ArcusCacheConfiguration> initialCacheConfig = new HashMap<>();
        initialCacheConfig.put("testCache", testCacheConfig());
        initialCacheConfig.put("devCache", devCacheConfig());
        return initialCacheConfig;
    }

    @Bean
    public ArcusCacheConfiguration testCacheConfig() {
        ArcusCacheConfiguration cacheConfig = new ArcusCacheConfiguration();
        cacheConfig.setServiceId("TEST-");
        cacheConfig.setPrefix("PRODUCT");
        cacheConfig.setExpireSeconds(60);
        cacheConfig.setTimeoutMilliSeconds(800);
        return cacheConfig;
    }

    @Bean
    public ArcusCacheConfiguration devCacheConfig() {
        ArcusCacheConfiguration cacheConfig = new ArcusCacheConfiguration();
        cacheConfig.setServiceId("DEV-");
        cacheConfig.setPrefix("PRODUCT");
        cacheConfig.setExpireSeconds(120);
        cacheConfig.setTimeoutMilliSeconds(800);
        return cacheConfig;
    }

}
