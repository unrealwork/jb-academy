package platform.api;

import org.springframework.stereotype.Service;
import platform.api.model.Code;
import platform.api.model.CodeUpdateResult;
import platform.api.model.NewCode;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class CodeServiceImpl implements CodeService {
    private static final List<Code> CODES = initialCode();

    @Override
    public List<Code> latest() {
        List<Code> res = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {

            final int index = CODES.size() - i - 1;
            if (index < 0) {
                break;
            }
            res.add(CODES.get(index));
        }
        return Collections.unmodifiableList(res);
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
        final int id = CODES.size();
        CODES.add(c);
        return new CodeUpdateResult(id);
    }

    private static List<Code> initialCode() {
        final List<Code> codes = new CopyOnWriteArrayList<>();
        return codes;
    }
}
