package ru.otus.https.server;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private String rawRequest;
    private String method;
    private String uri;
    private Map<String, String> paremetres;

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

    private void parse() {
        this.paremetres = new HashMap<>();
        int startIndex = rawRequest.indexOf(' ');
        int endIndex = rawRequest.indexOf(' ', startIndex + 1);
        this.method = rawRequest.substring(0, startIndex);
        this.uri = rawRequest.substring(startIndex + 1, endIndex);
        if (this.uri.contains("?")) {
            String[] tokens = uri.split("[?]");
            this.uri = tokens[0];
            String[] paramsPair = tokens[1].split("[&]");
            for (String o : paramsPair) {
                String[] keyValue = o.split("[=]");
                this.paremetres.put(keyValue[0], keyValue[1]);
            }
        }
    }

    public void info(boolean showRawRequest) {
        System.out.println("METHOD: " + method);
        System.out.println("URI: " + uri);
        if (showRawRequest) {
            System.out.println(rawRequest);
        }
    }


}

