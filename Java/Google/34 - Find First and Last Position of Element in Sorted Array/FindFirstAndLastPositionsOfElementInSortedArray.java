public class FindFirstAndLastPositionsOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int end = findEndIndex(nums, target);

        if (end == -1) return new int[] { -1, -1 };

        int start = findStartIndex(nums, target);

        return new int[] { start, end };
    }

    private int findStartIndex(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private int findEndIndex(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = (left + (right - left) / 2) + 1;

            if (nums[mid] == target) {
                left = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (left >= nums.length || nums[left] != target) ? -1 : left;
    }
}