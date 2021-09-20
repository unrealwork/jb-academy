package platform;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/code")
public class ApiCodeController {


    @GetMapping
    @ResponseBody
    public Code get() {
        return code();
    }

    private Code code() {
        Code code = new Code();
        code.setCode("public static void main(String[] args) {\n    SpringApplication.run(CodeSharingPlatform.class, args);\n}");
        return code;
    }
}
