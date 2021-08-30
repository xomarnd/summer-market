package ru.geekbrains.summer.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.summer.market.exceptions.ResourceNotFoundException;
import ru.geekbrains.summer.market.model.Category;
import ru.geekbrains.summer.market.model.CategoryEntity;
import ru.geekbrains.summer.market.repositories.CategoryRepository;

import java.util.Optional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Optional<CategoryEntity> findById(Long id) {
        return categoryRepository.findById(id);
    }
//    public Optional<Category> findById(Long id) {
//        return categoryRepository.findById(id);
//    }

    public static final Function<CategoryEntity, Category> functionEntityToSoap = ctge -> {
        Category ctg = new Category();
        ctg.setTitle(ctg.getTitle());
        ctge.getProducts().stream().map(ProductService.functionEntityToSoap).forEach(pr -> ctg.getProducts().add(pr));
        return ctg;
    };

    public ru.geekbrains.summer.market.soap.categories.Category getByTitle(String title) {
        return categoryRepository
                .findByTitle(title)
                .map(functionEntityToSoap)
                .orElseThrow(() -> new ResourceNotFoundException("Category " + title + " not found"));
    }

}
