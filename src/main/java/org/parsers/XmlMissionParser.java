package org.parsers;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.models.Mission;
import java.io.File;

public class XmlMissionParser implements IMissionParser {
    @Override
    public Mission parse(File file) throws Exception {
        XmlMapper mapper = new XmlMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(file, Mission.class);
    }
}