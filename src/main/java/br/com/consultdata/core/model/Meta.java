package br.com.consultdata.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Meta {
    @JsonProperty("totalRecords")
    public int getTotalRecords() {
        return this.totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    int totalRecords;

    @JsonProperty("totalPages")
    public int getTotalPages() {
        return this.totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    int totalPages;
}
