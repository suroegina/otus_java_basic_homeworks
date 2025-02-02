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

public class GetProductProcessor implements RequestProcessor{
    private static final Logger LOGGER = LogManager.getLogger(GetProductProcessor.class);

    private ProductsService productsService;

    public GetProductProcessor(ProductsService productsService) {
        this.productsService = productsService;
    }

    @Override
    public void execute(HttpRequest request, OutputStream output) throws IOException {
        String jsonResult = null;
        Gson gson = new Gson();
        if (request.containsParameter("id")) {
            Long id = Long.parseLong(request.getParemeter("id"));
            Product product = productsService.getProductById(id);
            jsonResult = gson.toJson(product);
            LOGGER.debug("Получение продукта по ИД - ОК");
        } else {
            List<Product> products = productsService.getAllProducts();
            jsonResult = gson.toJson(products);
            LOGGER.debug("Получение всех продуктов - ОК");
        }

        String response = "" +
                "HTTP/1.1 200 OK\r\n" +
                "Connect-Type: application/json\r\n" +
                "\r\n" +
                jsonResult;

        output.write(response.getBytes(StandardCharsets.UTF_8));
    }
}
