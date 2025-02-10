package ru.otus.http.server.processors;

import ru.otus.http.server.BadRequestException;
import ru.otus.http.server.HttpRequest;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class CalculatorProcessor implements RequestProcessor {
    @Override
    public void execute(HttpRequest request, OutputStream output) throws IOException {
        try {
            if (!request.containsParameter("a")) {
                throw new BadRequestException(
                        "VALIDATION_ERROR_MISSING_FIELD",
                        "Отсутствует параметр запроса 'a'"
                );
            }
            if (!request.containsParameter("b")) {
                throw new BadRequestException(
                        "VALIDATION_ERROR_MISSING_FIELD",
                        "Отсутствует параметр запроса 'b'"
                );
            }
            int a = Integer.parseInt(request.getParemeter("a"));
            int b = Integer.parseInt(request.getParemeter("b"));
            String result = a + " + " + b + " = " + (a + b);
            String response = "" +
                    "HTTP/1.1 200 OK\r\n" +
                    "Connect-Type: text/html\r\n" +
                    "\r\n" +
                    "<html><body><h1>" + result + "</h1></body></html>";
            output.write(response.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            String response = "" +
                    "HTTP/1.1 200 OK\r\n" +
                    "Connect-Type: text/html\r\n" +
                    "\r\n" +
                    "<html><body><h1>Incorrect Data for Calulator</h1></body></html>";
            output.write(response.getBytes(StandardCharsets.UTF_8));
        }
    }
}
