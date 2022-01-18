package br.com.consultdata.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PersonalAccount {
    @JsonProperty("type")
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    String type;

    @JsonProperty("fees")
    public Fees getFees() {
        return this.fees;
    }

    public void setFees(Fees fees) {
        this.fees = fees;
    }

    Fees fees;

    @JsonProperty("serviceBundles")
    public List<ServiceBundle> getServiceBundles() {
        return this.serviceBundles;
    }

    public void setServiceBundles(List<ServiceBundle> serviceBundles) {
        this.serviceBundles = serviceBundles;
    }

    List<ServiceBundle> serviceBundles;

    @JsonProperty("openingClosingChannels")
    public List<String> getOpeningClosingChannels() {
        return this.openingClosingChannels;
    }

    public void setOpeningClosingChannels(List<String> openingClosingChannels) {
        this.openingClosingChannels = openingClosingChannels;
    }

    List<String> openingClosingChannels;

    @JsonProperty("additionalInfo")
    public String getAdditionalInfo() {
        return this.additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    String additionalInfo;

    @JsonProperty("transactionMethods")
    public List<String> getTransactionMethods() {
        return this.transactionMethods;
    }

    public void setTransactionMethods(List<String> transactionMethods) {
        this.transactionMethods = transactionMethods;
    }

    List<String> transactionMethods;

    @JsonProperty("termsConditions")
    public TermsConditions getTermsConditions() {
        return this.termsConditions;
    }

    public void setTermsConditions(TermsConditions termsConditions) {
        this.termsConditions = termsConditions;
    }

    TermsConditions termsConditions;

    @JsonProperty("incomeRate")
    public IncomeRate getIncomeRate() {
        return this.incomeRate;
    }

    public void setIncomeRate(IncomeRate incomeRate) {
        this.incomeRate = incomeRate;
    }

    IncomeRate incomeRate;
}
