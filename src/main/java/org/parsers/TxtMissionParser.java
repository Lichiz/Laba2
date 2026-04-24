package org.parsers;

import org.models.Mission;
import java.io.*;
import java.util.*;

public class TxtMissionParser implements IMissionParser {
    @Override
    public Mission parse(File file) throws Exception {
        Mission mission = new Mission();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            String currentSection = "GENERAL";
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                if (line.startsWith("[") && line.endsWith("]")) {
                    currentSection = line.substring(1, line.length() - 1);
                    continue;
                }

                String[] parts = line.split("=", 2);
                if (parts.length < 2) continue;
                String key = parts[0].trim();
                String value = parts[1].trim();

                fillMission(mission, currentSection, key, value);
            }
        }
        return mission;
    }

    private void fillMission(Mission m, String section, String key, String value) {
        if (section.equals("MISSION")) {
            if (key.equals("id")) m.id = value;
            if (key.equals("location")) m.location = value;
            if (key.equals("outcome")) m.outcome = value;
        } else {
            m.extraFields.computeIfAbsent(section, k -> new LinkedHashMap<String, String>());
            ((Map<String, String>) m.extraFields.get(section)).put(key, value);
        }
    }
}