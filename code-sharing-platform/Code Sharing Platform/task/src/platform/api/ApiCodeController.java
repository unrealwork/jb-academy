package platform.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import platform.api.model.Code;
import platform.api.model.CodeUpdateResult;
import platform.api.model.NewCode;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/code")
public class ApiCodeController {
    private final CodeService codeService;

    public ApiCodeController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping("latest")
    @ResponseBody
    public List<Code> get() {
        return codeService.latest();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Code get(@PathVariable int id) {
        return codeService.findByIndex(id);
    }


    @PostMapping("/new")
    @ResponseBody
    public CodeUpdateResult newCode(final @RequestBody NewCode code) {
        return codeService.update(code);
    }
}
