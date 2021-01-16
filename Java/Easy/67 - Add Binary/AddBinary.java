public class AddBinary {
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        StringBuilder result = new StringBuilder();

        while (i >= 0 || j >= 0) {
            int b1 = (i >= 0) ? Character.getNumericValue(a.charAt(i--)) : 0;
            int b2 = (j >= 0) ? Character.getNumericValue(b.charAt(j--)) : 0;
            int sum = b1 + b2 + carry;
            carry = (sum == 3 || sum == 2) ? 1 : 0;
            result.append((sum == 1 || sum == 3) ? 1 : 0);
        }

        if (carry > 0) result.append(1);

        return result.reverse().toString();
    }
}