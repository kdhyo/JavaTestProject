package com.hyo.story.service.item;

import static org.assertj.core.api.Assertions.assertThat;

import com.querydsl.core.group.Group;
import java.util.Map;
import javax.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
class ItemServiceTest {

    @Autowired
    private ItemService itemService;

    @BeforeEach
    void setUp() {
        for (var i = 0; i < 10; i++) {
            ItemEntity item = ItemEntity.builder()
                .itemId(String.format("item-%04d", i))
                .itemName(String.format("아이템-%04d", i))
                .color("RED")
                .quantity(i)
                .build();

            itemService.save(item);
        }
    }

    @Test
    @DisplayName("Map value Integer 받기")
    void transform_groupBy_value_integer() {
        Map<String, Integer> items = itemService.getQuantity();
        Integer quantity = items.get("item-0001");
        assertThat(quantity).isEqualTo(1);
    }

    @Test
    @DisplayName("Map value Group 받기")
    void transform_groupBy_value_Group() {
        Map<String, Group> map = itemService.groupMap();
        Group group = map.get("item-0001");
        Object[] item = group.toArray();
        assertThat(item[0]).isEqualTo("item-0001");
        assertThat(item[1]).isEqualTo("아이템-0001");
        assertThat(item[2]).isEqualTo("RED");
    }


    @DisplayName("isCreateMode 가 true 일 시")
    void itemSaveTestCreatedMode() {
        for (var i = 0; i < 100; i++) {
            itemService.save(ItemEntity.builder().itemId("createdModeTEST" + i).itemName("createdModeTEST").color("red").isCreatedMode(true).build());
        }
    }

    @DisplayName("isCreateMode 가 false 일 시")
    void itemSaveTestNotCreatedMode() {
        for (var i = 0; i < 100000; i++) {
            itemService.save(ItemEntity.builder().itemId("notCreatedModeTEST" + i).itemName("notCreatedModeTEST").color("red").isCreatedMode(false).build());
        }
    }

}
