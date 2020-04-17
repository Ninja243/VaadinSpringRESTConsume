package com.mweya.restclient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class HttpBinResponse {
    private Header headers;
    private String origin;
    private String url;

    public HttpBinResponse() {
    }

    public void setHeaders(Header headers) {
        this.headers = headers;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Header getHeaders() {
        return headers;
    }

    public String getOrigin() {
        return origin;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Origin: " + this.origin + "; Header:" + this.headers.toString() + "; URL: " + this.url;
    }

}