public static boolean in(int[] nums, int num, int i) {
    for (int j = 0; j < nums.length; j++) {
        if (j != i && nums[j] == num) {
            return true;
        }
    }
    return false;
}