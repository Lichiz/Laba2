package org.parsers;
import org.models.Mission;
import java.io.File;

public interface IMissionParser {
    Mission parse(File file) throws Exception;
}