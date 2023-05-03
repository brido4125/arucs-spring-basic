package basic.arcusspring;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public Item saveItem(Item item) {
        itemRepository.save(item);
        return item;
    }

    @Cacheable(cacheManager = "cacheManager", cacheNames = "testCache", key = "#id")
    public Item findItem(Long id) {
        Item find = itemRepository.findById(id);
        System.out.println("find = by store" + find);
        return find;
    }
}
