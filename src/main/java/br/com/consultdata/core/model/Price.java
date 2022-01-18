package br.com.consultdata.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Price {
    @JsonProperty("interval")
    public String getInterval() {
        return this.interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    String interval;

    @JsonProperty("value")
    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    String value;

    @JsonProperty("currency")
    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    String currency;

    @JsonProperty("customers")
    public Customers getCustomers() {
        return this.customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    Customers customers;

    @JsonProperty("monthlyFee")
    public String getMonthlyFee() {
        return this.monthlyFee;
    }

    public void setMonthlyFee(String monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    String monthlyFee;
}
