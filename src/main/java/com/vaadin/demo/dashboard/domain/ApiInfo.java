package com.vaadin.demo.dashboard.domain;

import org.scribe.builder.api.Api;

/**
 * Created by Zeynin on 2016-06-09.
 */
public class ApiInfo
{
    private final String name;
    private final Class<? extends Api> scribeApi;
    private final String apiKey;
    private final String apiSecret;
    private final String exampleGetRequest;

    public ApiInfo(String name, Class<? extends Api> scribeApi,
                   String apiKey, String apiSecret, String exampleGetRequest)
    {
        super();
        this.name = name;
        this.scribeApi = scribeApi;
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.exampleGetRequest = exampleGetRequest;
    }

    public String getName() { return name; }

    public Class<? extends Api> getScribeApi() { return scribeApi; }

    public String getApiKey() { return apiKey; }

    public String getApiSecret() { return apiSecret; }

    public String getExampleGetRequest() { return exampleGetRequest; }
}