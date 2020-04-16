int count(int v) {
    int pv = find(v);
    if (colored[pv]) {
        return cnt[pv][1];
    } else {
        return Math.min(cnt[pv][0], cnt[pv][1]);
    }
}