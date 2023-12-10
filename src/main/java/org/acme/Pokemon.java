package org.acme;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

import jakarta.json.bind.annotation.JsonbProperty;

public class Pokemon {
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    @JsonbProperty("name")
    private Map<String, String> name;
    
    @Getter
    @Setter
    @JsonbProperty("type")
    private List<String> type;
    
    @Getter
    @Setter
    @JsonbProperty("base")
    private Map<String, Integer> base;

    public Pokemon() {
    }

    public Pokemon(int id, Map<String, String> name, List<String> type, String sprite, Map<String, Integer> base) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.base = base;
    }

    @Override
    public String toString() {
        return "Pokemon [ id=" + id + ", name=" + name + ", type=" + type + "base=" + base + " ]";
    }
}
