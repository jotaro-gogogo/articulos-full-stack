package labs.akagi.articulos.products.dao;

import labs.akagi.articulos.products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
    boolean existsByProductKey(String productKey);
    Optional<Product> findByProductKey(String productKey);
    void deleteByProductKey(String productKey);
}
