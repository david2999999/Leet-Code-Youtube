public class PalindromePartitioningBottomUpApproach {
    public List<List<String>> partition(String s) {
        List<List<String>>[] result = new List[s.length() + 1];

        for (int i = s.length(); i >= 0; i--) {
            result[i] = new ArrayList<>();

            if (i == s.length()) {
                result[i].add(new ArrayList<>());
                continue;
            }

            StringBuilder str = new StringBuilder();

            for (int j = i; j < s.length(); j++) {
                str.append(s.charAt(j));

                if (isPalindrome(s, i, j)) {
                    for (List<String> par: result[j + 1]) {
                        List<String> partitions = new ArrayList<>();
                        partitions.add(str.toString());
                        partitions.addAll(par);
                        result[i].add(partitions);
                    }
                }
            }
        }

        return result[0];
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }

        return true;
    }
}