public class LetterCombinationOfPhoneNumber {
    private static final char[][] MAPPINGS = {
        {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
        { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' }
    };

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();

        List<String> result = new ArrayList<>();
        letterCombinations(0, new StringBuilder(), result, digits);
        return result;
    }

    private void letterCombinations(int i, StringBuilder str, List<String> result, String digits) {
        if (i >= digits.length()) {
            result.add(str.toString());
            return;
        }

        char d = digits.charAt(i);

        for (char c: MAPPINGS[Character.getNumericValue(d)]) {
            str.append(c);
            letterCombinations(i + 1, str, result, digits);
            str.deleteCharAt(str.length() - 1);
        }
    }
}