package recipes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import recipes.persistance.Recipe;
import recipes.persistance.RecipeRepository;
import recipes.presentation.RecipeModel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecipeService implements MapRecipeService {
    private final RecipeRepository recipeRepository;

    @Override
    public synchronized AdditionResult save(RecipeModel recipe) {
        recipe.setDate(LocalDateTime.now().toString());
        final Recipe savedRecipe = recipeRepository.save(recipe.toDto());
        return AdditionResult.of(savedRecipe.getId());
    }

    @Override
    public void update(int id, RecipeModel recipe) {
        Recipe entity = recipe.toDto();
        entity.setId(id);
        entity.setDate(LocalDateTime.now().toString());
        recipeRepository.save(entity);
    }

    @Override
    public synchronized Optional<RecipeModel> findById(final int id) {
        return recipeRepository.findById(id).map(Recipe::toModel);
    }

    @Override
    public List<RecipeModel> findByCategory(String category) {
        return recipeRepository.findAllByCategory(category)
                .stream()
                .map(Recipe::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<RecipeModel> findByName(String name) {
        return recipeRepository.findAllByName(name)
                .stream()
                .map(Recipe::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {
        recipeRepository.deleteById(id);
    }
}
