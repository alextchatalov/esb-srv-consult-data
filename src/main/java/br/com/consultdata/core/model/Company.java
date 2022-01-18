package br.com.consultdata.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Company {
    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    @JsonProperty("cnpjNumber")
    public String getCnpjNumber() {
        return this.cnpjNumber;
    }

    public void setCnpjNumber(String cnpjNumber) {
        this.cnpjNumber = cnpjNumber;
    }

    String cnpjNumber;

    @JsonProperty("urlComplementaryList")
    public String getUrlComplementaryList() {
        return this.urlComplementaryList;
    }

    public void setUrlComplementaryList(String urlComplementaryList) {
        this.urlComplementaryList = urlComplementaryList;
    }

    String urlComplementaryList;

    @JsonProperty("personalAccounts")
    public List<PersonalAccount> getPersonalAccounts() {
        return this.personalAccounts;
    }

    public void setPersonalAccounts(List<PersonalAccount> personalAccounts) {
        this.personalAccounts = personalAccounts;
    }

    List<PersonalAccount> personalAccounts;
}
