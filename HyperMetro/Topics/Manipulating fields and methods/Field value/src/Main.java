import java.lang.reflect.Field;

/**
 * Get value for a given public field or null if the field does not exist or is not accessible.
 */
class FieldGetter {

    public Object getFieldValue(Object object, String fieldName) throws IllegalAccessException {
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            if (field.canAccess(object)) {
                return field.get(object);
            }
            return null;
        } catch (NoSuchFieldException e) {
            return null;
        }
    }

}
