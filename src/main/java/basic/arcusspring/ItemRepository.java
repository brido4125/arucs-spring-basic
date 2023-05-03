package basic.arcusspring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Repository
public class ItemRepository {

    private Map<Long, Item> store = new HashMap<>();

    public void save(Item item) {
        store.put(item.getId(), item);
    }

    public Item findById(Long id) {
        Item item = store.get(id);
        return item;
    }
}
