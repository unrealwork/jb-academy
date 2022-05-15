package animals.storage;

import animals.lang.Fact;
import animals.lang.Subject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FactStorageImpl implements FactStorage {
    private final Map<Fact, Set<Subject>> subjects = new HashMap<>();

    @Override
    public void add(Fact fact, Subject s) {
        subjects.computeIfAbsent(fact, f -> new HashSet<>())
                .add(s);
    }

    @Override
    public boolean has(Fact fact, Subject s) {
        return subjects.get(fact).contains(s);
    }
}
