package platform.presentation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import platform.api.CodeService;
import platform.api.model.Code;

@Controller
public class CodeController {
    private final CodeService codeService;
    
    @Value("classpath:views/code.html")
    private Resource codeView;
    
    @Value("classpath:views/code-new.html")
    private Resource codeNewView;

    public CodeController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping(value = "/code", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> code() {
        final Code code = codeService.code();
        return ResponseEntity.ok()
                .body("<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <title>Code</title>\n" +
                        "    <link rel=\"stylesheet\" href=\"/css/mini-default.min.css\">\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<div class=\"row\">\n" +
                        "    \n" +
                        "    <div class=\"col-sm-12 col-md-6\">\n" +
                        "        <p>\n" +
                        "            <mark class=\"tertiary\">\n" +
                        "                <span id=\"load_date\">" + code.getDate() + " </span>\n" +
                        "            </mark>\n" +
                        "        </p>\n" +
                        "        <pre id=\"code_snippet\">\n" +
                        code.getCode() +
                        "    </pre>\n" +
                        "    </div>\n" +
                        "</div>\n" +
                        "</body>");
    }


    @GetMapping("/code/new")
    public ResponseEntity<Resource> codenew() {
        return ResponseEntity
                .ok()
                .contentType(MediaType.TEXT_HTML)
                .body(codeNewView);
    }
}
