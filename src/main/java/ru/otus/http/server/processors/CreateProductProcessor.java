package ru.otus.http.server.processors;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.otus.http.server.Dispatcher;
import ru.otus.http.server.HttpRequest;
import ru.otus.http.server.application.Product;
import ru.otus.http.server.application.ProductsService;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class CreateProductProcessor implements RequestProcessor{
    private static final Logger LOGGER = LogManager.getLogger(CreateProductProcessor.class);

    private ProductsService productsService;

    public CreateProductProcessor(ProductsService productsService) {
        this.productsService = productsService;
    }

    @Override
    public void execute(HttpRequest request, OutputStream output) throws IOException {
        Gson gson = new Gson();
        Product newProduct = gson.fromJson(request.getBody(), Product.class);
        productsService.createNewProduct(newProduct);
        LOGGER.debug("Создание продукта - ОК: " + newProduct.toString());
        String response = "" +
                "HTTP/1.1 201 Created\r\n" +
                "Connect-Type: text/html\r\n" +
                "\r\n" +
                "<html><body><h1>CREATE Product</h1></body></html>";
        output.write(response.getBytes(StandardCharsets.UTF_8));
    }
}
