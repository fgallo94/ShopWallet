package com.fgallo.shopwallet.repository;

import com.fgallo.shopwallet.entity.Category;
import com.fgallo.shopwallet.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("Select item from Item item where category_internal_code = :id ")
    Page<Item> findAllItemsFromCategory(@Param("id") Long id, Pageable pageable);

}
