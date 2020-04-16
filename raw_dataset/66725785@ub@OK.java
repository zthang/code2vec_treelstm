public int ub(int x, long y) {
    int start = 0;
    int end = a[x].size() - 1;
    int ans = -1;
    while (start <= end) {
        int mid = (start + end) / 2;
        long got = (long) a[x].get(mid);
        if (y - got <= d) {
            ans = mid;
            end = mid - 1;
        } else
            start = mid + 1;
    }
    if (ans == -1) {
        return a[x].size();
    } else
        return ans;
}