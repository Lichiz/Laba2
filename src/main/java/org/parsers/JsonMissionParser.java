package org.parsers;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.models.Mission;
import java.io.File;

public class JsonMissionParser implements IMissionParser {
    @Override
    public Mission parse(File file) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(file, Mission.class);
    }
}