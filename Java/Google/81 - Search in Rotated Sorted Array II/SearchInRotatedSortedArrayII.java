public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        return search(0, nums.length - 1, nums, target);
    }

    private boolean search(int left, int right, int[] nums, int target) {
        if (left > right) return false;

        int mid = left + (right - left) / 2;

        if (nums[mid] == target) return true;

        if (nums[left] < nums[mid]) {
            if (nums[left] <= target && target < nums[mid]) {
                return search(left, mid - 1, nums, target);
            } else {
                return search(mid + 1, right, nums, target);
            }
        } else if (nums[mid] < nums[right]) {
            if (nums[mid] < target && target <= nums[right]) {
                return search(mid + 1, right, nums, target);
            } else {
                return search(left, mid - 1, nums, target);
            }
        } else {
            return search(left, mid - 1, nums, target) ? true :
                   search(mid + 1, right, nums, target);
        }
    }
}