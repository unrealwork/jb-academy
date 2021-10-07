package platform.api;

import org.springframework.stereotype.Service;
import platform.api.model.Code;
import platform.api.model.CodeUpdateResult;
import platform.api.model.NewCode;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class CodeServiceImpl implements CodeService {
    private static final List<Code> CODES = initialCode();

    @Override
    public Code code() {
        return CODES.get(CODES.size() - 1);
    }

    @Override
    public Code latest() {
        return CODES.get(CODES.size() - 1);
    }

    @Override
    public Code findByIndex(int id) {
        return CODES.get(id);
    }

    @Override
    public CodeUpdateResult update(NewCode newCode) {
        Code c = new Code();
        c.setCode(newCode.getCode());
        c.setDate(LocalDateTime.now().toString());
        CODES.add(c);
        return new CodeUpdateResult();
    }

    private static List<Code> initialCode() {
        Code code = new Code();
        code.setCode("public static void main(String[] args) {\n    SpringApplication.run(CodeSharingPlatform.class, args);\n}");
        code.setDate(LocalDateTime.now().toString());
        final List<Code> codes = new CopyOnWriteArrayList<>();
        codes.add(code);
        return codes;
    }
}
