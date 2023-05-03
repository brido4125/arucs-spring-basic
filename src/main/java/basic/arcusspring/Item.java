package basic.arcusspring;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Builder
@Getter
@Setter
public class Item implements Serializable {
    private Long id;
    private int price;
    private String name;
}
