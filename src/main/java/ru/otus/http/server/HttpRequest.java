package ru.otus.http.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private static final Logger LOGGER = LogManager.getLogger(HttpRequest.class);
    private String rawRequest;
    private HttpMethod method;
    private String uri;
    private Map<String, String> paremetres;
    private Map<String, String> headers;
    private String body;

    private Exception errorCause;

    public Exception getErrorCause() {
        return errorCause;
    }

    public void setErrorCause(Exception errorCause) {
        this.errorCause = errorCause;
    }

    public String getRoutingKey() {
        return method + " " + uri;
    }

    public HttpRequest(String rawRequest) {
        this.rawRequest = rawRequest;
        parse();
    }

    public String getUri() {
        return uri;
    }

    public String getParemeter(String key) {
        return paremetres.get(key);
    }

    public String getBody() {
        return body;
    }

    public boolean containsParameter(String key) {
        return paremetres.containsKey(key);
    }

    private void parse() {
        this.paremetres = new HashMap<>();
        this.headers = new HashMap<>();
        int startIndex = rawRequest.indexOf(' ');
        int endIndex = rawRequest.indexOf(' ', startIndex + 1);
        this.method = HttpMethod.valueOf(rawRequest.substring(0, startIndex));
        this.uri = rawRequest.substring(startIndex + 1, endIndex);
        if (this.uri.contains("?")) {
            String[] tokens = uri.split("[?]");
            this.uri = tokens[0];
            String[] paramsPair = tokens[1].split("[&]");
            for (String o : paramsPair) {
                String[] keyValue = o.split("=");
                this.paremetres.put(keyValue[0], keyValue[1]);
            }
        }
        rawRequest.lines()
                .skip(1)
                .takeWhile(s -> !s.isBlank())
                .forEach(
                        s -> {
                            String[] keyValue = s.split(": ");
                            headers.put(keyValue[0], keyValue[1]);
                        }
                );
        this.body = rawRequest.substring(rawRequest.indexOf("\r\n\r\n") + 4, rawRequest.length());
    }

    public void info(boolean showRawRequest) {
        System.out.println("METHOD: " + method);
        System.out.println("URI: " + uri);
        System.out.println("HEADERS: " + headers);
        System.out.println("BODY: " + body);
        LOGGER.info("METHOD: " + method);
        LOGGER.info("URI: " + uri);
        LOGGER.info("HEADERS: " + headers);
        LOGGER.info("BODY: " + body);
        if (showRawRequest) {
            System.out.println(rawRequest);
            LOGGER.info(rawRequest);
        }
    }


}
