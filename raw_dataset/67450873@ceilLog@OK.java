public static int ceilLog(int x) {
    int ans = floorLog(x);
    if ((1 << ans) < x) {
        ans++;
    }
    return ans;
}