package ru.otus.http.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Application {
    private static final Logger LOGGER = LogManager.getLogger(Application.class);
    public static void main(String[] args) {
        LOGGER.trace("Запускаем сервер...");
        HttpServer httpServer = new HttpServer(8189);
        httpServer.start();
    }
}

