package recipes.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import recipes.service.AdditionResult;
import recipes.persistance.Recipe;
import recipes.service.RecipeService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RecipeApiController {
    private final RecipeService recipeService;

    public RecipeApiController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("recipe/{id}")
    public RecipeModel get(final @PathVariable Integer id) {
        return recipeService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("recipe/new")
    public AdditionResult add(@RequestBody @Valid RecipeModel recipe) {
        return recipeService.save(recipe);
    }

    @PutMapping("recipe/{id}")
    public ResponseEntity<Void> update(@PathVariable int id,
                                       @RequestBody @Valid RecipeModel recipe) {
        if (recipeService.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        recipeService.update(id, recipe);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("recipe/search")
    public List<RecipeModel> update(@RequestParam(required = false) String category,
                                    @RequestParam(required = false) String name) {
        if (category != null && name != null || category == null && name == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if (category != null) {
            return recipeService.findByCategory(category);
        }
        return recipeService.findByName(name);
    }

    @DeleteMapping("recipe/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        if (recipeService.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        recipeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
