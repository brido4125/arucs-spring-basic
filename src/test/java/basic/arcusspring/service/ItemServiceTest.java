package basic.arcusspring.service;

import basic.arcusspring.Item;
import basic.arcusspring.ItemRepository;
import basic.arcusspring.ItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ItemServiceTest {

    private ItemService itemService;


    @BeforeEach
    void setup() {
        itemService = new ItemService(new ItemRepository());
        Item item1 = Item.builder()
                .id(2L)
                .price(20000)
                .name("macbook pro")
                .build();

        Item item2 = Item.builder()
                .id(1L)
                .price(30000)
                .name("macbook air")
                .build();
        //when
        itemService.saveItem(item1);
        itemService.saveItem(item2);
        //then
        itemService.findItem(1L);
        itemService.findItem(2L);
    }

    @Test
    void getItemTest() {
        //then
        Item find1 = itemService.findItem(2L);
        Item find2 = itemService.findItem(1L);
    }
}