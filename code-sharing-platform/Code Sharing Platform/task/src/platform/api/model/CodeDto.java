package platform.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor(staticName = "of")
public class CodeDto {
    String code;
    String date;
}
