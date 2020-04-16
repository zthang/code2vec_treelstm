public int lb(int x, long y) {
    int start = 0;
    int end = a[x].size() - 1;
    int ans = -1;
    while (start <= end) {
        int mid = (start + end) / 2;
        long got = (long) a[x].get(mid);
        if (got - y <= d) {
            ans = mid;
            start = mid + 1;
        } else
            end = mid - 1;
    }
    if (ans == -1) {
        return -1;
    } else
        return ans;
}