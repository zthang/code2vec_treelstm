void solve() {
    StringBuffer sb = new StringBuffer();
    int N = ni();
    a = na(N);
    dp = new int[N][2];
    g = new List[N];
    for (int i = 0; i < N; i++) g[i] = new ArrayList<Integer>();
    for (int i = 0; i < N; i++) {
        if (i + a[i] < N)
            g[i + a[i]].add(i);
        if (i - a[i] >= 0)
            g[i - a[i]].add(i);
    }
    for (int odd = 0; odd <= 1; odd++) {
        ArrayDeque<Integer> q = new ArrayDeque<Integer>();
        for (int i = 0; i < N; i++) if (a[i] % 2 == odd) {
            q.add(i);
            dp[i][odd] = 0;
        } else
            dp[i][odd] = -1;
        int steps = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int u = q.poll();
                for (int v : g[u]) {
                    if (dp[v][odd] == -1) {
                        dp[v][odd] = steps + 1;
                        q.add(v);
                    }
                }
            }
            steps++;
        }
    }
    for (int i = 0; i < N; i++) sb.append(dp[i][1 - a[i] % 2]).append(' ');
    out.println(sb);
}