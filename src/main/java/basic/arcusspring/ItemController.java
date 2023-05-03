package basic.arcusspring;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ItemController {

        private final ItemService itemService;

    @GetMapping("/")
    public String home() {
        itemService.saveItem(Item.builder().id(1L).name("air").price(1000).build());
        itemService.saveItem(Item.builder().id(2L).name("pro").price(1000).build());
        return "home";
    }

    @GetMapping("/item/{id}")
    public String getItem(@PathVariable Long id) {
        Item item = itemService.findItem(id);
        return item.getName();
    }
}
