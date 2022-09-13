package ru.gb.market_back.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.market_back.models.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
    // @Query("select p from Product p where p.price <= :maxPrice and p.price >= :minPrice")
    // List<Product> findAllByPriceAfterAndTitleContains(int minPrice, String s);
    /* List<Product> findByPriceBetween(int minPrice,int maxPrice);
    List<Product> findByTitle(String title);
    List<Product> findByPriceBefore(int max);
    List<Product> findByPriceAfter(int min); */

    Page<Product> findByPriceBetween(int min, int max, Pageable pageable);
    Page<Product> findByPriceAfter(int min, Pageable pageable);
    Page<Product> findByPriceBefore(int max, Pageable pageable);

}
