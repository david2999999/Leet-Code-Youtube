public class PlusOne {
    public int[] plusOne(int[] digits) {
        List<Integer> result = new LinkedList<>();
        int carry = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            carry = (sum > 9) ? 1 : 0;
            result.add(0, sum % 10);
        }

        if (carry > 0) result.add(0, 1);

        return result.stream().mapToInt(x -> x).toArray();
    }
}