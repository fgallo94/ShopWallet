# ShopWallet
REST Api for any shop model.
Made with Spring Boot, Spring Security, H2 Database and Project Lombok.
In an early future must be upgraded with new features, Test, CI, Docker and other amazing things.

## End-Points

*   ### Item Controller

End-Point      | Http Method | Description   
---------------|-------------|------------
/item/         |GET          | Get all items.
/item/         |POST         | Save item.
/item/{id}     |GET          | Get item by id.
/item/{id}     |PUT          | Modify item if exists or create new if not exists.
/item/{id}     |DELETE       | Delete item by id.


*   ### Category Controller

End-Point                      | Http Method | Description   
-------------------------------|-------------|------------
/category/                     |GET          | Get all categories.
/category/                     |POST         | Save category.
/category/{id}                 |GET          | Get category by id.
/category/{id}                 |PUT          | Modify category if exists or create new if not exists.
/category/{id}                 |DELETE       | Delete category by id.
/category/{id}/items           |GET          | Get items from category.
/category/{idCategory}/{idItem}|POST         | Add item to category.
/category/{idCategory}/{idItem}|DELETE       | Remove an item from category.

