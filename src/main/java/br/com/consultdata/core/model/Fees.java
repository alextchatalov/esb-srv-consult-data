package br.com.consultdata.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Fees {
    @JsonProperty("priorityServices")
    public List<PriorityService> getPriorityServices() {
        return this.priorityServices;
    }

    public void setPriorityServices(List<PriorityService> priorityServices) {
        this.priorityServices = priorityServices;
    }

    List<PriorityService> priorityServices;

    @JsonProperty("otherServices")
    public List<OtherService> getOtherServices() {
        return this.otherServices;
    }

    public void setOtherServices(List<OtherService> otherServices) {
        this.otherServices = otherServices;
    }

    List<OtherService> otherServices;
}
