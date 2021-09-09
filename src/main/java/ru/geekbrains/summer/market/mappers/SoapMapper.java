package ru.geekbrains.summer.market.mappers;

import org.springframework.stereotype.Component;
import ru.geekbrains.summer.market.model.Product;
import ru.geekbrains.summer.market.soap.GetProductByIdResponse;
import ru.geekbrains.summer.market.soap.GetProductsResponse;
import ru.geekbrains.summer.market.soap.ProductSoap;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SoapMapper {


    public GetProductByIdResponse toGetProductResponse(Product product) {
        GetProductByIdResponse getProductByIdResponse = new GetProductByIdResponse();
        ProductSoap productSoap = toProduct(product);
        getProductByIdResponse.setProduct(productSoap);
        return getProductByIdResponse;
    }

    public GetProductsResponse toGetProductsResponse(List<Product> productList) {
        List<ProductSoap> productSoapList = productList.stream()
                .map(this::toProduct)
                .collect(Collectors.toList());
        GetProductsResponse getProductsResponse = new GetProductsResponse();
        getProductsResponse.getProducts().addAll(productSoapList);
        return getProductsResponse;
    }

    private ProductSoap toProduct(Product product) {
        ProductSoap productSoap = new ProductSoap();
        productSoap.setId(product.getId());
        productSoap.setPrice(product.getPrice().doubleValue());
        productSoap.setTitle(product.getTitle());
        productSoap.setCategoryTitle(product.getCategory().getTitle());
        return productSoap;
    }
}
