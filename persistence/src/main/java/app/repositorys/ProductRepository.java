package app.repositorys;

import app.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ProductRepository extends JpaRepository<Product, Long>
{
    @Modifying
    @Query(value = "INSERT INTO product (title, description, is_available, unit_price) " +
            "VALUES (:#{#product.title}, :#{#product.description}, :#{#product.is_available}, :#{#product.unit_price});",
            nativeQuery = true)
    @Transactional
    Product saveAndReturnProducts(@Param("product") Product product);
}
