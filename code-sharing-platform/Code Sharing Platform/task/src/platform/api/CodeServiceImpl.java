package platform.api;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import platform.api.model.CodeDto;
import platform.api.model.CodeUpdateResult;
import platform.persistence.Code;
import platform.persistence.CodeRepository;
import platform.util.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CodeServiceImpl implements CodeService {
    private final CodeRepository codeRepository;

    @Override
    public List<CodeDto> latest() {
        Pageable limit = PageRequest.of(0, 10);
        return codeRepository.findByOrderByTsDesc(limit)
                .stream().map(ModelMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CodeDto findByIndex(long id) {
        return codeRepository.findById(id).map(ModelMapper::toDto).orElse(null);
    }

    @Override
    public CodeUpdateResult update(CodeDto newCode) {
        final Code code = ModelMapper.toEntity(newCode);
        code.setTs(System.currentTimeMillis());
        final Code codeUpdated = codeRepository.save(code);
        return new CodeUpdateResult(Long.toString(codeUpdated.getId()));
    }
}
