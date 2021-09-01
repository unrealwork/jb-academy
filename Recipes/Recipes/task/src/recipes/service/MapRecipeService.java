package recipes.service;

import recipes.persistance.Recipe;

import java.util.Optional;

public interface MapRecipeService {
    AdditionResult add(Recipe recipe);

    Optional<Recipe> findById(int id);
    
    void deleteById(int id);
}
