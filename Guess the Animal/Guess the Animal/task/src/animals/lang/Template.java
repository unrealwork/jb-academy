package animals.lang;

public interface Template {
    String format(Object... objs);

    static Template create(String templateText) {
        return new TemplateImpl(templateText);
    }

}
