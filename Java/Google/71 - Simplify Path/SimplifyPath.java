public class SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] directories = path.split("/");

        for (String dir: directories) {
            if (dir.isEmpty() || dir.equals(".")) continue;

            if (dir.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(dir);
            }
        }

        return convertToString(stack);
    }

    private String convertToString(Deque<String> stack) {
        StringBuilder result = new StringBuilder();

        while (!stack.isEmpty()) {
            result.append("/").append(stack.removeLast());
        }

        if (result.length() == 0) result.append("/");

        return result.toString();
    }
}