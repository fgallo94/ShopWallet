package com.fgallo.shopwallet.entity;

import com.fgallo.shopwallet.entity.Item;
import com.fgallo.shopwallet.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ItemRepository ItemRepository;

    @Test
    public void whenFindByIdWithBuilder() {
        Item item = Item.builder()
                .internalCode(0L)
                .code("0001")
                .description("Description test")
                .price(new BigDecimal(32f))
                .build();
        entityManager.persist(item);
        entityManager.flush();
        Item found = ItemRepository.findById(item.getInternalCode()).get();
        assert (found)
                .equals(item);
    }

    @Test
    public void testSetters(){
        Item item = Item.builder().build();
        item.setCode("0001");
        item.setDescription("Description test");
        item.setInternalCode(1L);
        item.setPrice(new BigDecimal(32));
        assert (item.getCode())
                .equals("0001");
        assert (item.getDescription())
                .equals("Description test");
        assert (item.getInternalCode())
                .equals(1L);
        assert (item.getPrice())
                .equals(new BigDecimal(32));
    }

}