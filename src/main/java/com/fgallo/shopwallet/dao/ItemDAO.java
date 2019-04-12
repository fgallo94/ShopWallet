package com.fgallo.shopwallet.dao;

import com.fgallo.shopwallet.dto.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDAO extends JpaRepository<Item, Long> {

}
