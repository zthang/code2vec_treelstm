static void solve() {
    n = in.nextInt();
    a = new int[n];
    for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
    }
    lp = new int[N + 1];
    lp[1] = 1;
    primes = new int[N + 1];
    primes[0] = 1;
    ind = new int[N + 1];
    primes[1] = m++;
    for (int i = 2; i <= N; i++) {
        if (lp[i] == 0) {
            lp[i] = i;
            primes[m] = i;
            ind[i] = m++;
            if ((long) i * i > N)
                continue;
            for (int j = i * i; j <= N; j += i) {
                if (lp[j] == 0)
                    lp[j] = i;
            }
        }
    }
    set = new HashSet<>();
    g = new ArrayList[m];
    Arrays.setAll(g, gg -> new ArrayList<>());
    for (int i = 0; i < n; i++) {
        int sq = (int) Math.sqrt(a[i]);
        if (sq * sq == a[i]) {
            out.println(1);
            return;
        }
        int aa = a[i];
        int v = lp[aa], u = 1;
        int cnt = 0;
        while (lp[aa] == v) {
            cnt++;
            aa /= lp[aa];
        }
        if (cnt % 2 == 0)
            v = 1;
        if (aa > 1) {
            u = lp[aa];
            cnt = 0;
            while (lp[aa] == u) {
                cnt++;
                aa /= lp[aa];
            }
            if (cnt % 2 == 0)
                u = 1;
        }
        g[ind[v]].add(ind[u]);
        g[ind[u]].add(ind[v]);
        set.add(v * u);
    }
    if (set.size() != n) {
        out.println(2);
        return;
    }
    int ans = INF;
    int sq = (int) Math.ceil(Math.sqrt(N));
    q = new ArrayDeque<>();
    d = new int[m];
    p = new int[m];
    for (int i = 1; i <= sq; i++) {
        if (lp[i] != i)
            continue;
        for (int v = 0; v < m; v++) {
            d[v] = -1;
            p[v] = -1;
        }
        int v = ind[i];
        q.addLast(v);
        d[v] = 0;
        p[v] = v;
        while (!q.isEmpty()) {
            v = q.pollFirst();
            if (d[v] + 1 >= ans) {
                q.clear();
                break;
            }
            for (int u : g[v]) {
                if (d[u] == -1) {
                    d[u] = d[v] + 1;
                    p[u] = v;
                    q.addLast(u);
                } else if (p[v] != u) {
                    ans = Math.min(ans, d[v] + d[u] + 1);
                }
            }
        }
    }
    if (ans == INF) {
        out.println(-1);
    } else {
        out.println(ans);
    }
}