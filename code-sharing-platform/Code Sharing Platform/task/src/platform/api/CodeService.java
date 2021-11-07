package platform.api;

import platform.api.model.Code;
import platform.api.model.CodeUpdateResult;
import platform.api.model.NewCode;

import java.util.List;

public interface CodeService {
    List<Code> latest();
    Code findByIndex(int id);
    CodeUpdateResult update(NewCode code);
}
