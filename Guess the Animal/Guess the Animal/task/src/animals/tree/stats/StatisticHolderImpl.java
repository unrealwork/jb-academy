package animals.tree.stats;

import animals.lang.Fact;
import animals.tree.TreeNode;
import animals.util.MapBuilder;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

class StatisticHolderImpl implements StatisticHolder {
    private final Map<StatisticType, Statistic> statStorage;

    public StatisticHolderImpl(Map<StatisticType, Statistic> statStorage) {
        this.statStorage = new LinkedHashMap<>(statStorage);
    }

    @Override
    public Object get(StatisticType type) {
        return statStorage.get(type).get();
    }

    public static StatisticHolder fromTree(TreeNode<Fact> treeNode) {
        MapBuilder<StatisticType, Statistic> builder = MapBuilder.immutable();
        Map<TreeNode<Fact>, Integer> nodeToHeight = new HashMap<>();
        heightOrder(treeNode, nodeToHeight::put);
        if (treeNode != null) {
            fillStatistics(treeNode, builder, nodeToHeight);
        }
        return new StatisticHolderImpl(builder.build());
    }

    private static void fillStatistics(TreeNode<Fact> root, MapBuilder<StatisticType, Statistic> builder, Map<TreeNode<Fact>, Integer> nodeToHeight) {
        builder.put(StatisticType.ROOT_NODE, Statistics.fact(root.val()));
        int totalNodes = 0;
        int totalAnimals = 0;
        int height = 0;
        int minDepth = Integer.MAX_VALUE;
        int leaveDepthSum = 0;
        for (Map.Entry<TreeNode<Fact>, Integer> kv : nodeToHeight.entrySet()) {
            totalNodes++;
            if (kv.getKey().isTerminal()) {
                totalAnimals++;
                if (kv.getValue() > height) {
                    height = kv.getValue();
                }
                if (kv.getValue() < minDepth) {
                    minDepth = kv.getValue();
                }
                leaveDepthSum += kv.getValue();
            }
        }
        builder.put(StatisticType.HEIGHT, Statistics.integer(height));
        if (totalAnimals > 0) {
            builder.put(StatisticType.AVG_DEPTH, Statistics.real(leaveDepthSum / (double) totalAnimals));
        }
        builder.put(StatisticType.MIN_DEPTH, Statistics.integer(minDepth));
        builder.put(StatisticType.TOTAL_NODES, Statistics.integer(totalNodes));
        builder.put(StatisticType.TOTAL_ANIMALS, Statistics.integer(totalAnimals));
        builder.put(StatisticType.TOTAL_STATEMENTS, Statistics.integer(totalNodes - totalAnimals));
    }

    private static <T> void heightOrder(final TreeNode<T> node, BiConsumer<TreeNode<T>, Integer> heightNodeConsumer) {
        heightOrder(node, 0, heightNodeConsumer);
    }

    private static <T> void heightOrder(final TreeNode<T> node, int height, BiConsumer<TreeNode<T>, Integer> heightNodeConsumer) {
        if (node != null) {
            heightOrder(node.left(), height + 1, heightNodeConsumer);
            heightNodeConsumer.accept(node, height);
            heightOrder(node.right(), height + 1, heightNodeConsumer);
        }
    }
}
