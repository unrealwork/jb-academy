import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 Get number of accessible public fields for a given class.
 */
class FieldGetter {

    public int getNumberOfAccessibleFields(Class<?> clazz) {
        // Add implementation here
        long count = 0L;
        for (Field f : clazz.getFields()) {
            if (Modifier.isPublic(f.getModifiers())) {
                count++;
            }
        }
        return (int) count;
    }

}
