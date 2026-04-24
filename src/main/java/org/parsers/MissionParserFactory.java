package org.parsers;

import java.io.File;

public class MissionParserFactory {
    public static IMissionParser getParser(File file) {
        String name = file.getName().toLowerCase();

        if (name.endsWith(".json")) {
            return new JsonMissionParser();
        } else if (name.endsWith(".xml")) {
            return new XmlMissionParser();
        } else if (name.endsWith(".yaml") || name.endsWith(".yml")) {
            return new YamlMissionParser();
        } else if (name.endsWith(".txt")) {
            return new TxtMissionParser();
        } else {
            return new BinMissionParser();
        }
    }
}