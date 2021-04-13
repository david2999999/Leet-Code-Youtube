public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int i = 0, count = 0;

        for (int j = 0; j < nums.length; j++) {
            count++;

            if (count <= 2) {
                nums[i++] = nums[j];
            }

            if (j == nums.length - 1 || nums[j] != nums[j + 1]) {
                count = 0;
            }
        }

        return i;
    }
}