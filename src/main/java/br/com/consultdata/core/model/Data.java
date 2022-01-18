package br.com.consultdata.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {
    @JsonProperty("brand")
    public Brand getBrand() {
        return this.brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    Brand brand;
}
