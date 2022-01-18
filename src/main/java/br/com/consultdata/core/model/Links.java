package br.com.consultdata.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Links{
    @JsonProperty("self")
    public String getSelf() {
        return this.self; }
    public void setSelf(String self) {
        this.self = self; }
    String self;
    @JsonProperty("first")
    public String getFirst() {
        return this.first; }
    public void setFirst(String first) {
        this.first = first; }
    String first;
    @JsonProperty("last")
    public String getLast() {
        return this.last; }
    public void setLast(String last) {
        this.last = last; }
    String last;
}
