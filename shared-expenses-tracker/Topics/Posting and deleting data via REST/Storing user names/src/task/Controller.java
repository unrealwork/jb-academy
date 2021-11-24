package task;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RequestMapping("/users")
@RestController
public class Controller {
    private final List<String> list = new CopyOnWriteArrayList<>();

    @GetMapping
    public List<String> get() {
        return list;
    }

    @PostMapping
    public void add(@RequestParam String name) {
        list.add(name);
    }
}
