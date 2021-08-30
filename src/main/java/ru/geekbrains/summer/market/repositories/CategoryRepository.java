package ru.geekbrains.summer.market.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.geekbrains.summer.market.model.CategoryEntity;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    @Query("select g from CategoryEntity g where g.title = ?1")
    Optional<CategoryEntity> findByTitle(String title);
//public interface CategoryRepository extends JpaRepository<Category, Long> {
}
