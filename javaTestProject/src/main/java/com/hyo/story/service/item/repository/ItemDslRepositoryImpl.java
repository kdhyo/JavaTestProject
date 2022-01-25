package com.hyo.story.service.item.repository;

import static com.querydsl.core.group.GroupBy.groupBy;

import com.hyo.story.service.item.QItemEntity;
import com.querydsl.core.group.Group;
import java.util.Map;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class ItemDslRepositoryImpl extends QuerydslRepositorySupport implements ItemDslRepository {

    private final QItemEntity qItem = QItemEntity.itemEntity;

    public ItemDslRepositoryImpl() {
        super(QItemEntity.class);
    }

    @Override
    public Map<String, Integer> getQuantity() {
        return from(qItem)
            .transform(groupBy(qItem.itemId).as(qItem.quantity));
    }

    @Override
    public Map<String, Group> getGroup() {
        return from(qItem)
            .transform(groupBy(qItem.itemId).as(qItem.itemName, qItem.color));
    }

}
