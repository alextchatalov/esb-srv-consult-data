package br.com.bestbank.backbestbank.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MinimumBalance {
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
}
