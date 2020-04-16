private static int getAns(int[] nums, Pair[] edges) {
    boolean[][] taken = new boolean[6][6];
    int ans = 0;
    for (Pair e : edges) {
        int mn = Math.min(nums[e.a], nums[e.b]);
        int mx = Math.max(nums[e.a], nums[e.b]);
        if (!taken[mn][mx]) {
            taken[mn][mx] = true;
            ans++;
        }
    }
    return ans;
}