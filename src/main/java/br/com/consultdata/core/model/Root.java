package br.com.consultdata.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Root{
    @JsonProperty("data")
    public Data getData() {
        return this.data; }
    public void setData(Data data) {
        this.data = data; }
    Data data;
    @JsonProperty("links")
    public Links getLinks() {
        return this.links; }
    public void setLinks(Links links) {
        this.links = links; }
    Links links;
    @JsonProperty("meta")
    public Meta getMeta() {
        return this.meta; }
    public void setMeta(Meta meta) {
        this.meta = meta; }
    Meta meta;
}


