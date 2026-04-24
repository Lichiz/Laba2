package org.models;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAnySetter;

public class Mission {
    @JsonProperty("missionId")
    public String id;
    public String date;
    public String location;

    @JsonProperty("damageCost")
    public int damage;
    public Curse curse;
    public List<Sorcerer> sorcerers = new ArrayList<>();
    public List<Technique> techniques = new ArrayList<>();
    public String outcome;

    @JsonAnySetter
    public void addExtra(String key, Object value) {
        this.extraFields.put(key, value);
    }

    public Map<String, Object> extraFields = new LinkedHashMap<>();
    public Mission() {}
}