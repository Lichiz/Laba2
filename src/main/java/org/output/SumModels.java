package org.output;

import org.models.Mission;

public class SumModels implements Sum {
    protected Mission mission;

    public SumModels(Mission mission) {
        this.mission = mission;
    }

    @Override
    public void print() {
        System.out.println("----------- ОТЧЕТ ПО МИССИИ ------------");
        System.out.println("ID: " + mission.id);
        System.out.println("Локация: " + mission.location);
        System.out.println("Дата: " + mission.date);
        System.out.println("Результат: " + mission.outcome);
    }
}