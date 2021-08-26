package recipes;

public interface MapRecipeService {
    AdditionResult add(Recipe recipe);

    Recipe findById(int id);
}
