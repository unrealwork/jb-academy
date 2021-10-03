package platform.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import platform.api.model.Code;
import platform.api.model.CodeUpdateResult;
import platform.api.model.NewCode;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/code")
public class ApiCodeController {
    private final CodeService codeService;

    public ApiCodeController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping
    @ResponseBody
    public Code get() {
        return code();
    }

    private Code code() {
        return codeService.code();
    }


    @PostMapping("/new")
    @ResponseBody
    public Map<String, String> newCode(final @RequestBody NewCode code) {
        codeService.update(code);
        return Collections.emptyMap();
    }
}
