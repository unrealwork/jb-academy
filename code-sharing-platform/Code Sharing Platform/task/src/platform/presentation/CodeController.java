package platform.presentation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import platform.api.CodeService;
import platform.api.model.Code;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/code")
public class CodeController {
    private final CodeService codeService;

    @Value("classpath:views/code-new.html")
    private Resource codeNewView;

    public CodeController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping(value = "latest")
    public String code(Model model) {
        final List<Code> codes = codeService.latest();
        model.addAttribute("codes", codes);
        model.addAttribute("title","Latest");
        return "code";
    }
    
    @GetMapping("{id}")
    public String idCode(Model model, @PathVariable int id) {
        final Code code = codeService.findByIndex(id);
        model.addAttribute("codes", Collections.singleton(code));
        
        return "code";
    }
    
    @GetMapping("new")
    public ResponseEntity<Resource> codenew() {
        return ResponseEntity
                .ok()
                .contentType(MediaType.TEXT_HTML)
                .body(codeNewView);
    }
}
