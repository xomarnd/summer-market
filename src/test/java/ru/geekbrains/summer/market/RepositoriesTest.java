package ru.geekbrains.summer.market;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import ru.geekbrains.summer.market.model.Product;
import ru.geekbrains.summer.market.repositories.ProductRepository;

import java.math.BigDecimal;
import java.util.List;

@DataJpaTest
@ActiveProfiles("test")
public class RepositoriesTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void goProductRepositoryTest() {
        Product product = new Product();
        product.setTitle("Borsh");
        product.setPrice(BigDecimal.valueOf(148));
        entityManager.persist(product);
        entityManager.flush();

        List<Product> products = productRepository.findAll();

        Assertions.assertEquals(4, products.size());
        Assertions.assertEquals("Borsh", products.get(3).getTitle());
    }

    @Test
    public void initDbTest() {
        List<Product> products = productRepository.findAll();
        Assertions.assertEquals(3, products.size());
    }
}