package ru.geekbrains.summer.market.endpoints;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.geekbrains.summer.market.services.CategoryService;
import ru.geekbrains.summer.market.soap.categories.GetCategoryByTitleRequest;
import ru.geekbrains.summer.market.soap.categories.GetCategoryByTitleResponse;

@RequiredArgsConstructor
@Endpoint
public class CategoryEndpoint {

    private static final String NAMESPACE_URI = "http://www.geekbrains.ru/summer/ws/categories";
    private final CategoryService ctgService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCategoryByTitleRequest")
    @ResponsePayload
    @Transactional
    public GetCategoryByTitleResponse getGroupByTitle(@RequestPayload GetCategoryByTitleRequest request) {
        GetCategoryByTitleResponse response = new GetCategoryByTitleResponse();
        response.setCategory(ctgService.getByTitle(request.getTitle()));
        return response;
    }
}