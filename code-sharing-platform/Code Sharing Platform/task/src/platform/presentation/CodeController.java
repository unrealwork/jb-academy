package platform.presentation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import platform.api.CodeService;
import platform.api.model.Code;

@Controller
public class CodeController {
    private final CodeService codeService;
    
    @Value("classpath:views/ftl/code.ftl")
    private Resource codeView;
    
    @Value("classpath:views/code-new.html")
    private Resource codeNewView;

    public CodeController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping(value = "/code")
    public String code(Model model) {
        final Code code = codeService.code();
        model.addAttribute("code", code);
        return "code";
    }


    @GetMapping("/code/new")
    public ResponseEntity<Resource> codenew() {
        return ResponseEntity
                .ok()
                .contentType(MediaType.TEXT_HTML)
                .body(codeNewView);
    }
}
