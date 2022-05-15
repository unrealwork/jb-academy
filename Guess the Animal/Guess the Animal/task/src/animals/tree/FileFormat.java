package animals.tree;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public enum FileFormat {
    JSON(new JsonMapper()), XML(new XmlMapper()), YAML(new YAMLMapper());
    private final ObjectMapper mapper;

    FileFormat(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public static FileFormat fromArgs(String[] args) {
        if (args.length == 2 && "-type".equals(args[0])) {
            return FileFormat.valueOf(args[1].toUpperCase());
        }
        return FileFormat.JSON;
    }

    public ObjectMapper getMapper() {
        return mapper;
    }
}
