package br.com.consultdata.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Brand{
    @JsonProperty("name")
    public String getName() {
        return this.name; }
    public void setName(String name) {
        this.name = name; }
    String name;
    @JsonProperty("companies")
    public List<Company> getCompanies() {
        return this.companies; }
    public void setCompanies(List<Company> companies) {
        this.companies = companies; }
    List<Company> companies;
}
