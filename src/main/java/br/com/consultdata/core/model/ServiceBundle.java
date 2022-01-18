package br.com.consultdata.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ServiceBundle {
    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    @JsonProperty("services")
    public List<Service> getServices() {
        return this.services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    List<Service> services;

    @JsonProperty("prices")
    public List<Price> getPrices() {
        return this.prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    List<Price> prices;

    @JsonProperty("minimum")
    public Minimum getMinimum() {
        return this.minimum;
    }

    public void setMinimum(Minimum minimum) {
        this.minimum = minimum;
    }

    Minimum minimum;

    @JsonProperty("maximum")
    public Maximum getMaximum() {
        return this.maximum;
    }

    public void setMaximum(Maximum maximum) {
        this.maximum = maximum;
    }

    Maximum maximum;
}
