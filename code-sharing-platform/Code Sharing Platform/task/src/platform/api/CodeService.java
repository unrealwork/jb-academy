package platform.api;

import platform.api.model.Code;
import platform.api.model.CodeUpdateResult;
import platform.api.model.NewCode;

public interface CodeService {
    Code code();

    CodeUpdateResult update(NewCode code);
}