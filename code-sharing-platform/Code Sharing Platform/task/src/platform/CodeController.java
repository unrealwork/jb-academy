package platform;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CodeController {
    @Value("classpath:code.html")
    private Resource resource;


    @GetMapping(value = "/code", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<Resource> code() {
        return ResponseEntity.ok()
                .body(resource);
    }
}
