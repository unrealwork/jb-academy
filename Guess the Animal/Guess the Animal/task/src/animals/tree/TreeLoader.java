package animals.tree;


import animals.lang.Expression;
import animals.lang.Fact;
import animals.lang.Subject;
import animals.lang.Token;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;

public class TreeLoader {
    private TreeLoader() {
    }

    private static Path getDefaultPath(final FileFormat fileFormat) {
        Locale locale = Locale.getDefault();
        boolean isDefaultLang = Locale.US.getLanguage().equals(locale.getLanguage());
        final String localeSuffix = isDefaultLang ? "" : ("_" + locale.getLanguage().toLowerCase());
        return Paths.get("animals" + localeSuffix + "." + fileFormat.name().toLowerCase());
    }

    public static TreeNode<Fact> load(FileFormat format) {
        try (InputStream is = Files.newInputStream(getDefaultPath(format))) {
            return toTreeNode(format.getMapper().readValue(is, TreeNodeModel.class));
        } catch (IOException e) {
            return null;
        }
    }

    public static void save(TreeNode<Fact> factTreeNode, FileFormat fileFormat) {
        try (OutputStream os = Files.newOutputStream(getDefaultPath(fileFormat))) {
            fileFormat.getMapper().writerWithDefaultPrettyPrinter()
                    .writeValue(os, toModel(factTreeNode));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private static TreeNodeModel toModel(TreeNode<Fact> factTreeNode) {
        TreeNodeModel model = new TreeNodeModel();
        model.setData(extractData(factTreeNode));
        if (!factTreeNode.isTerminal()) {
            model.setNo(toModel(factTreeNode.left()));
            model.setYes(toModel(factTreeNode.right()));
        }
        return model;
    }

    private static String extractData(TreeNode<Fact> factTreeNode) {
        if (factTreeNode.isTerminal()) {
            List<Token> tokens = factTreeNode.val().exp().tokens();
            return Expression.fromTokens(tokens.subList(2, tokens.size()))
                    .asText();
        }
        return factTreeNode.val().exp().asText();
    }

    private static TreeNode<Fact> toTreeNode(TreeNodeModel model) {
        if (model == null) {
            return null;
        }
        TreeNode<Fact> treeNode = TreeNode.create(extractFact(model));
        if (!model.isLeaf()) {
            treeNode.setRight(toTreeNode(model.getYes()));
            treeNode.setLeft(toTreeNode(model.getNo()));
        }
        return treeNode;
    }

    private static Fact extractFact(TreeNodeModel model) {
        if (model.isLeaf()) {
            Expression exp = Expression.parse(model.getData());
            return Fact.fromSubject(new Subject(exp));
        } else {
            return Fact.fromExpression(Expression.parse(model.getData()));
        }
    }
}
