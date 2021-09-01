package recipes.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import recipes.service.AdditionResult;
import recipes.persistance.Recipe;
import recipes.service.RecipeService;

import javax.validation.Valid;

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
                .map(Recipe::toModel)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("recipe/new")
    public AdditionResult add(@RequestBody @Valid RecipeModel recipe) {
        return recipeService.add(recipe.toDto());
    }

    @DeleteMapping("recipe/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Recipe recipe = recipeService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        recipeService.deleteById(recipe.getId());
        return ResponseEntity.noContent().build();
    }
}
