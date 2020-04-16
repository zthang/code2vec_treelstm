void set(int cnt0, int cnt1) {
    cnt[0] = Math.min(INF, cnt[0] + cnt0);
    cnt[1] = Math.min(INF, cnt[1] + cnt1);
}