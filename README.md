# ShopWallet
REST Api for any shop model.
Made with Spring Boot, Spring Security, H2 Database and Project Lombok.
In an early future must be upgraded with new features, Test, CI, Docker and other amazing things.

## End-Points

*   ### Item Controller

End-Point | Http Method | Description   
----------|-------------|------------
/         |GET          | Get all items.
/         |POST         | Save item.
/{id}     |GET          | Get item by id.
/{id}     |PUT          | Modify item if exists or create new if not exists.
/{id}     |DELETE       | Delete item by id.


*   ### Category Controller

End-Point | Http Method | Description   
----------|-------------|------------
/         |GET          | Get all categories.
/         |POST         | Save category.
/{id}     |GET          | Get category by id.
/{id}     |PUT          | Modify category if exists or create new if not exists.
/{id}     |DELETE       | Delete category by id.
