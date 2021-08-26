package recipes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class RecipeApiController {
    private final RecipeService recipeService;

    public RecipeApiController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("recipe/{id}")
    public Recipe get(final @PathVariable Integer id) {
        final Recipe recipe = recipeService.findById(id);
        if (recipe == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return recipe;
    }

    @PostMapping("recipe/new")
    public AdditionResult add(@RequestBody Recipe recipe) {
        return recipeService.add(recipe);
    }
}
