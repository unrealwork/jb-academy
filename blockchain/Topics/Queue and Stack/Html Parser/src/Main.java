import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

class Main {
    public static void main(String[] args) throws IOException {
        // put your code here
        Deque<Element> elementDeque = new LinkedList<>();
        StateMachine stateMachine = new StateMachine();
        StringBuilder sb = new StringBuilder();
        try (InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8)) {
            int read = reader.read();
            while (read != -1) {
                char c = (char) read;
                ReadingState beforeState = stateMachine.currentState;
                ReadingState afterState = stateMachine.update(c);
                read = reader.read();
                if (beforeState == ReadingState.TAG && afterState == ReadingState.TAG || afterState == ReadingState.CONTENT) {
                    sb.append(c);
                }
                if (afterState != ReadingState.TAG && beforeState == ReadingState.TAG && afterState != ReadingState.CLOSING_TAG) {
                    final String tagName = sb.toString();
                    sb.setLength(0);
                    elementDeque.push(new Element(tagName));
                }
                if (afterState != ReadingState.CLOSING_TAG && beforeState == ReadingState.CLOSING_TAG) {
                    Element element = elementDeque.pop();
                    if (!elementDeque.isEmpty()) {
                        elementDeque.peek().children.add(element);
                    }
                    System.out.println(element.inner());
                    sb.setLength(0);
                }

                if (afterState != ReadingState.CONTENT && beforeState == ReadingState.CONTENT) {
                    if (!elementDeque.isEmpty()) {
                        elementDeque.peek().setContent(sb.toString());
                    }
                    sb.setLength(0);
                }

            }
        }
    }


    private enum ReadingState {WAIT, TAG, CONTENT, CLOSING_TAG}

    private static class Element {
        private final String tagName;
        private final List<Element> children;
        private String content;

        Element(final String tagName) {
            this.tagName = tagName;
            this.children = new LinkedList<>();
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getTagName() {
            return tagName;
        }

        public String inner() {
            if (content != null) {
                return content;
            } else {
                StringBuilder sb = new StringBuilder();
                for (Element child : children) {
                    final String childElement = String.format("<%s>%s</%s>", child.tagName, child.inner(), child.tagName);
                    sb.append(childElement);
                }
                return sb.toString();
            }
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Element.class.getSimpleName() + "[", "]")
                    .add("tagName='" + tagName + "'")
                    .add("children=" + children)
                    .add("content='" + content + "'")
                    .toString();
        }
    }


    private static class StateMachine {
        private ReadingState currentState = ReadingState.WAIT;

        ReadingState update(final char c) {
            final ReadingState nextState = next(c);
            currentState = nextState;
            return nextState;
        }

        ReadingState next(final char c) {
            if (c == '<' && (currentState == ReadingState.WAIT || currentState == ReadingState.CONTENT)) {
                return ReadingState.TAG;
            }
            if (c == '>' && currentState == ReadingState.TAG) {
                return ReadingState.WAIT;
            }
            if (c == '/' && currentState == ReadingState.TAG) {
                return ReadingState.CLOSING_TAG;
            }
            if (c == '>' && currentState == ReadingState.CLOSING_TAG) {
                return ReadingState.WAIT;
            }
            if (currentState == ReadingState.WAIT) {
                return Character.isWhitespace(c) ? ReadingState.WAIT : ReadingState.CONTENT;
            }
            return currentState;
        }
    }
}
