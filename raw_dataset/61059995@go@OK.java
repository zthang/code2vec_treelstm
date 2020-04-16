static int go(int cur) {
    if (cur == n) {
        int res = 0;
        for (int i = 0; i < m; i++) {
            int ca = color[a[i]], cb = color[b[i]];
            if (!have[ca][cb]) {
                have[ca][cb] = have[cb][ca] = true;
                ++res;
            }
        }
        for (int i = 0; i < m; i++) {
            int ca = color[a[i]], cb = color[b[i]];
            have[ca][cb] = have[cb][ca] = false;
        }
        return res;
    }
    int res = 0;
    for (int i = 0; i < cnt; i++) {
        color[cur] = i;
        res = max(res, go(cur + 1));
    }
    if (cnt < 6) {
        color[cur] = cnt;
        ++cnt;
        res = max(res, go(cur + 1));
        --cnt;
    }
    return res;
}