package common.action.builder;

import common.action.ActionType;

public interface ActionBuilderFactory {
    ActionBuilder byType(ActionType actionType);
}
