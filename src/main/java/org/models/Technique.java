package org.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Technique {
    public String name;
    public String user;
    @JsonProperty("damage")
    public int power;
}