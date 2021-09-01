package recipes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import recipes.persistance.Recipe;
import recipes.persistance.RecipeRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecipeService implements MapRecipeService {
    private final RecipeRepository recipeRepository;

    @Override
    public synchronized AdditionResult add(Recipe recipe) {
        final Recipe savedRecipe = recipeRepository.save(recipe);
        return AdditionResult.of(savedRecipe.getId());
    }

    @Override
    public synchronized Optional<Recipe> findById(final int id) {
        return recipeRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
        recipeRepository.deleteById(id);
    }
}
