package recipes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("recipe")
    public Recipe get() {
        return recipeService.get();
    }

    @PostMapping("recipe")
    public void add(@RequestBody Recipe recipe) {
        recipeService.set(recipe);
    }
}
