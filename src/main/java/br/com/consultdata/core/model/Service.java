package br.com.consultdata.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Service {
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

    @JsonProperty("eventLimitQuantity")
    public String getEventLimitQuantity() {
        return this.eventLimitQuantity;
    }

    public void setEventLimitQuantity(String eventLimitQuantity) {
        this.eventLimitQuantity = eventLimitQuantity;
    }

    String eventLimitQuantity;

    @JsonProperty("freeEventQuantity")
    public String getFreeEventQuantity() {
        return this.freeEventQuantity;
    }

    public void setFreeEventQuantity(String freeEventQuantity) {
        this.freeEventQuantity = freeEventQuantity;
    }

    String freeEventQuantity;
}
