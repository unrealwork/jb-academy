package platform.api;

import platform.api.model.CodeDto;
import platform.api.model.CodeUpdateResult;

import java.util.List;

public interface CodeService {
    List<CodeDto> latest();

    CodeDto findByIndex(long id);

    CodeUpdateResult update(CodeDto code);
}
