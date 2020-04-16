public int sum(int r) {
    int ans = 0;
    for (; r >= 0; r = (r & (r + 1)) - 1) {
        ans += sum[r];
    }
    return ans;
}