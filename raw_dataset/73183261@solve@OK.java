void solve() {
    int N = ni();
    int K = ni();
    p = new int[N + 1];
    size = new int[N + 1];
    cnt = new int[N + 1];
    for (int i = 1; i <= N; i++) size[i] = 1;
    for (int i = 0; i < K; i++) {
        connect(ni(), ni());
    }
    // tr(p, cnt, size);
    int ans = 0;
    for (int i = 1; i <= N; i++) {
        if (p[i] == 0) {
            ans += Math.max(0, cnt[i] - size[i] + 1);
        }
    }
    out.println(ans);
}