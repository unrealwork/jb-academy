package platform.api;

import org.springframework.stereotype.Service;
import platform.api.model.Code;
import platform.api.model.CodeUpdateResult;
import platform.api.model.NewCode;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class CodeServiceImpl implements CodeService {
    private static final AtomicReference<Code> STORING_CODE = new AtomicReference<>(initialCode());

    @Override
    public Code code() {
        return STORING_CODE.get();
    }

    @Override
    public CodeUpdateResult update(NewCode newCode) {
        Code c = new Code();
        c.setCode(newCode.getCode());
        c.setDate(LocalDateTime.now().toString());
        STORING_CODE.set(c);
        return new CodeUpdateResult();
    }

    private static Code initialCode() {
        Code code = new Code();
        code.setCode("public static void main(String[] args) {\n    SpringApplication.run(CodeSharingPlatform.class, args);\n}");
        code.setDate(LocalDateTime.now().toString());
        return code;
    }
}
