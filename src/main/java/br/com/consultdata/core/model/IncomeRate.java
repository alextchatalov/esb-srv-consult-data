package br.com.consultdata.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IncomeRate {
    @JsonProperty("savingAccount")
    public String getSavingAccount() {
        return this.savingAccount;
    }

    public void setSavingAccount(String savingAccount) {
        this.savingAccount = savingAccount;
    }

    String savingAccount;

    @JsonProperty("prepaidPaymentAccount")
    public String getPrepaidPaymentAccount() {
        return this.prepaidPaymentAccount;
    }

    public void setPrepaidPaymentAccount(String prepaidPaymentAccount) {
        this.prepaidPaymentAccount = prepaidPaymentAccount;
    }

    String prepaidPaymentAccount;
}
