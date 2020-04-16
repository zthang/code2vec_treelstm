public void solve(int testNumber, InputReader in, PrintWriter out) {
    this.out = out;
    this.in = in;
    int n = ni();
    int m = ni();
    int i = 0;
    for (i = 0; i < n; i++) {
        graph[i] = new ArrayList<>();
        hola[i] = new ArrayList<>();
        tset.add(i);
    }
    for (i = 0; i < m; i++) {
        int u = ni() - 1;
        int v = ni() - 1;
        graph[u].add(v);
        graph[v].add(u);
    }
    int c = 0;
    for (i = 0; i < n; i++) {
        if (!vis[i]) {
            dfs(i, c);
            c++;
        }
    }
    int ans = 0;
    while (tset.size() > 0) {
        int top = tset.first();
        int comp = which[top];
        int mx = 0, mn = n + 5;
        int cnt = 0;
        for (int u : hola[comp]) {
            mx = Math.max(mx, u);
            mn = Math.min(mn, u);
            tset.remove(u);
            cnt++;
        }
        while (mx - mn + 1 != cnt) {
            top = tset.first();
            comp = which[top];
            for (int u : hola[comp]) {
                mx = Math.max(mx, u);
                mn = Math.min(mn, u);
                tset.remove(u);
                cnt++;
            }
            ans++;
        }
    }
    pn(ans);
}