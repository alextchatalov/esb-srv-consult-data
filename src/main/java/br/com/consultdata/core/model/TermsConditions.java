package br.com.consultdata.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TermsConditions {
    @JsonProperty("minimumBalance")
    public MinimumBalance getMinimumBalance() {
        return this.minimumBalance;
    }

    public void setMinimumBalance(MinimumBalance minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    MinimumBalance minimumBalance;

    @JsonProperty("elegibilityCriteriaInfo")
    public String getElegibilityCriteriaInfo() {
        return this.elegibilityCriteriaInfo;
    }

    public void setElegibilityCriteriaInfo(String elegibilityCriteriaInfo) {
        this.elegibilityCriteriaInfo = elegibilityCriteriaInfo;
    }

    String elegibilityCriteriaInfo;

    @JsonProperty("closingProcessInfo")
    public String getClosingProcessInfo() {
        return this.closingProcessInfo;
    }

    public void setClosingProcessInfo(String closingProcessInfo) {
        this.closingProcessInfo = closingProcessInfo;
    }

    String closingProcessInfo;
}
