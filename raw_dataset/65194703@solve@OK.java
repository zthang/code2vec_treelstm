public void solve() throws QuickAnswer {
    Graph g = Graph.builder().build(in);
    int[] c = new int[g.n];
    int[] min = new int[g.n + 1];
    int color = 0;
    int[] togo = new int[g.n];
    for (int i = 0; i < g.n; i++) {
        if (c[i] > 0)
            continue;
        int b = 0;
        int e = 0;
        togo[e++] = i;
        c[i] = ++color;
        min[color] = i;
        while (b < e) {
            for (int n : g.neighbors[togo[b++]]) {
                if (c[n] > 0)
                    continue;
                c[n] = color;
                togo[e++] = n;
            }
        }
    }
    int minroot = g.n;
    int cnt = 0;
    int[] c2 = new int[g.n];
    for (int i = g.n - 1; i >= 0; i--) {
        int m = min[c[i]];
        if (c2[m] == 0) {
            c2[m] = 1;
            if (m < minroot)
                minroot = m;
            ++cnt;
        }
        if (i == minroot)
            --cnt;
    }
    print(cnt);
}