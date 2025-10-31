package com.nihar.ecommerce.repository;

import com.nihar.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //This is a custom query method using HQL. Explicitly define the query logic
    //http://localhost:7777/api/categories?minPrice=2500
    //this line of code is part of Spring Data JPA, and it defines a custom JPQL (Java Persistence Query Language) query.
    @Query("SELECT p FROM Product p WHERE p.price > :minPrice")
    List<Product> findByPriceGreaterThan(@Param("minPrice") double minPrice);

    //Full-Text Search using MySQL’s MATCH ... AGAINST syntax — wrapped inside a Spring Data JPA custom query.
    @Query(value="Select * FROM product WHERE MATCH(title, description) AGAINST (:keyword)", nativeQuery = true)
    List<Product> searchFullText(@Param("keyword") String keyword);

    //:minPrice < "minPrice" in @Param("minPrice")
    //:brand < "brand" in @Param("brand")
    @Query("Select p from Product p WHERE p.price > :minPrice AND p.brand = :brand")
    List<Product> findByBrandAndPrice(
            @Param("minPrice") int price,
            @Param("brand") String brandName
    );


}
