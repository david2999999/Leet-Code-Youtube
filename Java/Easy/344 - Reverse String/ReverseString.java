public class ReverseString {
    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;

        while (i < j) {
            swap(i++, j--, s);
        }
    }

    public void swap(int i, int j, char[] s) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}