public void solve(int testNumber, FastReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    for (int i = 1; i <= n; i++) p[i] = i;
    int cnt = 0;
    for (int i = 0; i < k; i++) {
        int u, v;
        u = in.nextInt();
        v = in.nextInt();
        if (cycle(u, v))
            cnt++;
        else
            Union(u, v);
    }
    out.println(cnt);
}