public class ValidParentheses {
    private static final String OPEN_BRACKETS = "([{";
    private static final String CLOSING_BRACKETS = ")]}";

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (isOpeningBracket(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !isMatching(stack.pop(), c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private boolean isOpeningBracket(char c) {
        return OPEN_BRACKETS.indexOf(c) != -1;
    }

    private boolean isMatching(char open, char close) {
        return OPEN_BRACKETS.indexOf(open) == CLOSING_BRACKETS.indexOf(close);
    }
}