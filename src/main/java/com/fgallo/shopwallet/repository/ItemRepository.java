package com.fgallo.shopwallet.repository;

import com.fgallo.shopwallet.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "/item")
public interface ItemRepository extends JpaRepository<Item, Long> {

}
