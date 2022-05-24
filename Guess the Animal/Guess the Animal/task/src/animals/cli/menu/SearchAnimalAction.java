package animals.cli.menu;

import animals.cli.Action;
import animals.cli.ActionFactory;
import animals.lang.Expression;
import animals.lang.Fact;
import animals.lang.Subject;
import animals.lang.Token;
import animals.lang.composer.Composer;
import animals.storage.MessageKeys;
import animals.storage.MessageStorage;
import animals.tree.TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


class SearchAnimalAction implements Action<Void> {
    private final ActionFactory factory;
    private final MessageStorage storage;
    private final TreeNode<Fact> tree;

    public SearchAnimalAction(ActionFactory factory, MessageStorage storage, TreeNode<Fact> tree) {
        this.factory = factory;
        this.storage = storage;
        this.tree = tree;
    }

    @Override
    public Void execute() {
        String res = factory.question(storage.find(MessageKeys.ENTER_ANIMAL)).execute();
        final Subject animal = new Subject(Expression.parse(res));
        factory.message(buildMessage(animal)).execute();
        return null;
    }


    private TreeNode<Fact> findAnimal(Map<TreeNode<Fact>, TreeNode<Fact>> map, final Subject subject) {
        for (Map.Entry<TreeNode<Fact>, TreeNode<Fact>> kv : map.entrySet()) {
            if (sameAnimal(kv.getKey(), subject)) {
                return kv.getKey();
            }
        }
        return null;
    }

    private boolean sameAnimal(TreeNode<Fact> key, Subject subject) {
        if (key.isTerminal()) {
            List<Token> tokens = key.val().exp().tokens();
            Expression exp = Expression.fromTokens(tokens.subList(2, tokens.size()));
            return new Subject(exp).withoutArticle().asText().equals(subject.withoutArticle().asText());
        }
        return false;
    }

    private String buildMessage(Subject animal) {
        String animalText = animal.withoutArticle().asText();
        StringBuilder builder = new StringBuilder();

        final Map<TreeNode<Fact>, TreeNode<Fact>> parentsMap = parentsMap(tree);
        TreeNode<Fact> animalNode = findAnimal(parentsMap, animal);
        if (animalNode == null) {
            builder.append(storage.template(MessageKeys.NO_FACTS, animalText));
        } else {
            TreeNode<Fact> child = animalNode;
            TreeNode<Fact> parent = parentsMap.get(child);
            if (parent != null) {
                builder.append(storage.template(MessageKeys.FACTS_ABOUT, animalText)).append(System.lineSeparator());
            }
            Deque<String> facts = new LinkedList<>();
            while (parent != null) {
                String fact = Composer.aboutIt(parent.val(),parent.right() == child).asText();
                facts.addFirst(fact);
                child = parent;
                parent = parentsMap.get(parent);
            }
            for (String fact : facts) {
                builder.append(" - ")
                        .append(fact)
                        .append(System.lineSeparator());
            }
        }
        return builder.toString();
    }

    private Map<TreeNode<Fact>, TreeNode<Fact>> parentsMap(TreeNode<Fact> tree) {
        final Map<TreeNode<Fact>, TreeNode<Fact>> parentsNode = new HashMap<>();
        parentsTraverse(tree, null, parentsNode);
        return parentsNode;
    }

    private void parentsTraverse(TreeNode<Fact> node, TreeNode<Fact> parent, Map<TreeNode<Fact>, TreeNode<Fact>> parentsMap) {
        if (node != null) {
            parentsMap.put(node, parent);
            parentsTraverse(node.left(), node, parentsMap);
            parentsTraverse(node.right(), node, parentsMap);
        }
    }
}
