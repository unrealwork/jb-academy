package platform.util;

import platform.api.model.CodeDto;
import platform.persistence.Code;

import java.time.Instant;

public class ModelMapper {
    private ModelMapper() {

    }

    public static CodeDto toDto(final Code code) {
        final String date = Instant.ofEpochMilli(code.getTs()).toString();
        return CodeDto.of(code.getCode(), date);
    }

    public static Code toEntity(final CodeDto codeDto) {
        final Code code = new Code();
        if (codeDto.getDate() != null) {
            code.setTs(Instant.parse(codeDto.getDate()).toEpochMilli());
        }
        code.setCode(codeDto.getCode());
        return code;
    }
}
