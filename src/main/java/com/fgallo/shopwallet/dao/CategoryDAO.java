package com.fgallo.shopwallet.dao;

import com.fgallo.shopwallet.dto.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDAO extends JpaRepository<Category, Long> {

}
