import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 Get list of public fields the object declares (inherited fields should be skipped).
 */
class FieldGetter {

    public String[] getPublicFields(Object object) {
        // Add implementation here
        Class<?> clz = object.getClass();
        return Arrays.stream(clz.getDeclaredFields())
                .filter(f -> Modifier.isPublic(f.getModifiers()))
                .map(Field::getName)
                .toArray(String[]::new);
    }

}
