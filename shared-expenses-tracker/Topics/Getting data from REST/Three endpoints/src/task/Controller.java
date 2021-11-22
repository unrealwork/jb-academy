package task;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Controller {
    @GetMapping("/value")
    public int value() {
        return 1;
    }

    @GetMapping("/text")
    public String text() {
        return "two";
    }

    @GetMapping("/json")
    public Map<String, Integer> json() {
        return Map.of("number", 3);
    }
}
