package ru.otus.http.server.processors;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.otus.http.server.HttpRequest;
import ru.otus.http.server.application.Product;
import ru.otus.http.server.application.ProductsService;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.NoSuchElementException;

public class UpdateProductProcessor implements RequestProcessor{
    private static final Logger LOGGER = LogManager.getLogger(UpdateProductProcessor.class);
    private ProductsService productsService;

    public UpdateProductProcessor(ProductsService productsService) {
        this.productsService = productsService;
    }

    @Override
    public void execute(HttpRequest request, OutputStream output) throws IOException {
        String jsonResult = null;
        Gson gson = new Gson();
        Product newProduct = gson.fromJson(request.getBody(), Product.class);
        Long newId = newProduct.getId();
        try {
            Product product = productsService.getProductById(newId);
            System.out.println(product.getTitle());
            product.setTitle(newProduct.getTitle());
            LOGGER.debug("Обновление продукта - ОК: " + newProduct.toString());
        } catch (NoSuchElementException e) {
            productsService.createNewProduct(newProduct);
            LOGGER.debug("Обновление продукта - Продукта в списке нет. Создание: " + newProduct.toString());
        }

        jsonResult = gson.toJson(newProduct);

        String response = "" +
                "HTTP/1.1 200 OK\r\n" +
                "Connect-Type: application/json\r\n" +
                "\r\n" +
                jsonResult;
        output.write(response.getBytes(StandardCharsets.UTF_8));
    }
}
