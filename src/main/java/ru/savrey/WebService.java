package ru.savrey;

public class WebService {
    private final HttpClient httpClient;

    public WebService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public String getInfoFromSite(String url) {
        return httpClient.get(url);
    }
}
