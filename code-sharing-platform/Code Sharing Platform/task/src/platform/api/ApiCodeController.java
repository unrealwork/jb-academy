package platform.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import platform.api.model.CodeDto;
import platform.api.model.CodeUpdateResult;

import java.util.List;

@RestController
@RequestMapping("/api/code")
public class ApiCodeController {
    private final CodeService codeService;

    public ApiCodeController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping("latest")
    @ResponseBody
    public List<CodeDto> get() {
        return codeService.latest();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public CodeDto get(@PathVariable int id) {
        return codeService.findByIndex(id);
    }


    @PostMapping("/new")
    @ResponseBody
    public CodeUpdateResult newCode(final @RequestBody CodeDto code) {
        return codeService.update(code);
    }
}
