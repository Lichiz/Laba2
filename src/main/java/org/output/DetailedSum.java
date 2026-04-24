package org.output;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.models.Mission;

public class DetailedSum extends SumDecorator {
    private final Mission mission;
    private final ObjectMapper mapper;

    public DetailedSum(Sum sum, Mission mission) {
        super(sum);
        this.mission = mission;
        this.mapper = new ObjectMapper();
        this.mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    @Override
    public void print() {
        super.print();
        System.out.println("\n----------- ДЕТАЛИЗАЦИЯ МИССИИ -----------");

        if (mission.curse != null) {
            System.out.println("Проклятие: " + mission.curse.name + " (Уровень: " + mission.curse.level + ")");
        }
        if (mission.sorcerers != null && !mission.sorcerers.isEmpty()) {
            System.out.println("Участники:");
            mission.sorcerers.forEach(s -> System.out.println(" - " + s.name + " [" + s.rank + "]"));
        }
        if (mission.techniques != null && !mission.techniques.isEmpty()) {
            System.out.println("Примененные техники:");
            mission.techniques.forEach(t -> System.out.println(" - " + t.name + " (Владелец: " + t.user + ")"));
        }
        if (mission.extraFields != null && !mission.extraFields.isEmpty()) {
            System.out.println("\n----------- ДОПОЛНИТЕЛЬНЫЕ ПАРАМЕТРЫ -----------");
            mission.extraFields.forEach((key, value) -> {
                try {
                    String prettyValue = mapper.writeValueAsString(value);
                    System.out.println(key + ": " + prettyValue);
                } catch (Exception e) {
                    System.out.println(key + ": " + value);
                }
            });
        }
        System.out.println("----------- КОНЕЦ АНАЛИТИКИ -----------");
    }
}