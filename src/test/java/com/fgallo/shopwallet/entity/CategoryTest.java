package com.fgallo.shopwallet.entity;

import com.fgallo.shopwallet.repository.CategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void whenFindByIdWithBuilder() {
        Category category = Category.builder()
                .internalCode(0L)
                .code("0001")
                .description("Description test")
                .build();
        entityManager.persist(category);
        entityManager.flush();
        Category found = categoryRepository.findById(category.getInternalCode()).get();
        assert (found)
                .equals(category);
    }

    @Test
    public void testSetters() {
        Category category = Category.builder().build();
        category.setCode("0001");
        category.setDescription("Description test");
        category.setInternalCode(1L);
        assert (category.getCode())
                .equals("0001");
        assert (category.getDescription())
                .equals("Description test");
        assert (category.getInternalCode())
                .equals(1L);
    }

}