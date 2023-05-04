package basic.arcusspring.service;

import basic.arcusspring.Item;
import basic.arcusspring.ItemRepository;
import basic.arcusspring.ItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
class ItemServiceTest {

    @Autowired
    ItemService itemService;


    @BeforeEach
    void setup() {
        itemService = new ItemService(new ItemRepository());
        Item item1 = Item.builder()
                .id(1L)
                .price(20000)
                .name("macbook pro")
                .build();

        itemService.saveItem(item1);
    }

    @Test
    void getItemTest() {
        //then
        itemService.findItem(1L);
        itemService.findItem(1L);
    }
}