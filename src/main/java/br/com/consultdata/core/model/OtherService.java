package br.com.consultdata.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OtherService {
    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    @JsonProperty("code")
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    String code;

    @JsonProperty("chargingTriggerInfo")
    public String getChargingTriggerInfo() {
        return this.chargingTriggerInfo;
    }

    public void setChargingTriggerInfo(String chargingTriggerInfo) {
        this.chargingTriggerInfo = chargingTriggerInfo;
    }

    String chargingTriggerInfo;

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
