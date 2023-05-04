package basic.arcusspring;

import com.navercorp.arcus.spring.cache.ArcusCacheConfiguration;
import com.navercorp.arcus.spring.cache.ArcusCacheManager;
import lombok.extern.slf4j.Slf4j;
import net.spy.memcached.ArcusClientPool;
import net.spy.memcached.ConnectionFactoryBuilder;
import org.springframework.cache.Cache;

import java.util.Collection;
import java.util.Map;

@Slf4j
public class MyCacheManager extends ArcusCacheManager {
    public MyCacheManager(ArcusClientPool client, ArcusCacheConfiguration defaultConfiguration, Map<String, ArcusCacheConfiguration> initialCacheConfigs) {
        super(client, defaultConfiguration, initialCacheConfigs);
    }

    public MyCacheManager(String adminAddress, String serviceCode, ConnectionFactoryBuilder connectionFactoryBuilder, int poolSize, ArcusCacheConfiguration defaultConfiguration, Map<String, ArcusCacheConfiguration> initialCacheConfigs) {
        super(adminAddress, serviceCode, connectionFactoryBuilder, poolSize, defaultConfiguration, initialCacheConfigs);
    }

    @Override
    protected Collection<? extends Cache> loadCaches() {
        log.info("loadCaches() called");
        return super.loadCaches();
    }

    @Override
    protected Cache getMissingCache(String name) {
        return super.getMissingCache(name);
    }

    @Override
    protected Cache createCache(String name, ArcusCacheConfiguration configuration) {
        return super.createCache(name, configuration);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
