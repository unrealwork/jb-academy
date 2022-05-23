package animals.cli;

import animals.lang.Fact;
import animals.storage.MessageKeys;
import animals.storage.MessageStorage;
import animals.tree.TreeNode;
import animals.tree.stats.StatisticHolder;
import animals.tree.stats.StatisticType;
import animals.util.MapBuilder;

import java.text.MessageFormat;
import java.util.Map;

public class StatisticsAction implements Action<Void> {
    private static final Map<StatisticType, String> LABEL_MAP = MapBuilder.<StatisticType, String>immutable()
            .put(StatisticType.ROOT_NODE, MessageKeys.STAT_ROOT_NODE)
            .put(StatisticType.TOTAL_NODES, MessageKeys.STAT_TOTAL_NODES)
            .put(StatisticType.TOTAL_ANIMALS, MessageKeys.STAT_TOTAL_ANIMALS)
            .put(StatisticType.TOTAL_STATEMENTS, MessageKeys.STAT_TOTAL_STATEMENTS)
            .put(StatisticType.HEIGHT, MessageKeys.STAT_HEIGHT)
            .put(StatisticType.MIN_DEPTH, MessageKeys.STAT_MIN_DEPTH)
            .put(StatisticType.AVG_DEPTH, MessageKeys.STAT_AVG_DEPTH)
            .build();
    private final ActionFactory actionFactory;
    private final MessageStorage storage;
    private final TreeNode<Fact> tree;

    public StatisticsAction(ActionFactory actionFactory, MessageStorage storage, TreeNode<Fact> tree) {
        this.actionFactory = actionFactory;
        this.storage = storage;
        this.tree = tree;
    }

    @Override
    public Void execute() {
        String statDesc = buildStatDesc();
        actionFactory.message(statDesc)
                .execute();
        return null;
    }

    private String buildStatDesc() {
        StringBuilder builder = new StringBuilder(storage.find(MessageKeys.STAT_TITLE));
        StatisticHolder statisticHolder = StatisticHolder.fromTree(tree);

        for (StatisticType type : StatisticType.values()) {
            MessageFormat template = statLabel(type);
            String formattedStat = template.format(new Object[] {statisticHolder.get(type)});
            builder.append(formattedStat)
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }

    private MessageFormat statLabel(StatisticType type) {
        return storage.template(LABEL_MAP.get(type));
    }
}
