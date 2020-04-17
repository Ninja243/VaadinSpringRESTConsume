package com.mweya.restclient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Header {
    private String Accept;
    private String Dnt;
    private String host;

    public Header() {
    }

    public String getAccept() {
        return this.Accept;
    }

    public String getDnt() {
        return this.Dnt;
    }

    public String getHost() {
        return this.host;
    }

    public void setAccept(String accept) {
        Accept = accept;
    }

    public void setDnt(String dnt) {
        Dnt = dnt;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public String toString() {
        return "{Accept: " + this.Accept + ";   Dnt: " + this.Dnt + ";   Host: " + this.host + "}";
    }
}