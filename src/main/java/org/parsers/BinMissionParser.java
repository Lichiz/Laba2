package org.parsers;

import org.models.Mission;
import java.io.*;
import java.util.*;

public class BinMissionParser implements IMissionParser {
    @Override
    public Mission parse(File file) throws Exception {
        Mission mission = new Mission();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split("\\|");
                if (parts.length < 2) continue;

                String key = parts[0].trim();
                String value = String.join(" | ", Arrays.copyOfRange(parts, 1, parts.length));

                mapData(mission, key, value);
            }
        }
        return mission;
    }

    private void mapData(Mission m, String key, String value) {
        switch (key) {
            case "MISSION_CREATED":
                String[] info = value.split(" \\| ");
                m.id = info[0];
                if (info.length > 1) m.date = info[1];
                if (info.length > 2) m.location = info[2];
                break;
            case "MISSION_RESULT":
                m.outcome = value;
                break;
            default:
                m.extraFields.merge(key, value, (oldV, newV) -> oldV + " ; " + newV);
                break;
        }
    }
}