package carsharing.cli;

class AnswerActionDecorator<T> extends BaseAnswerAction<T> {
    private final BaseAnswerAction<T> baseAnswerAction;

    AnswerActionDecorator(BaseAnswerAction<T> baseAnswerAction) {
        super(baseAnswerAction.scanner());
        this.baseAnswerAction = baseAnswerAction;
    }

    @Override
    T read() {
        return baseAnswerAction.read();
    }
}
