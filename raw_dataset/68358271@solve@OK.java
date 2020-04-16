void solve() {
    int n = ni();
    g = new List[n + 1];
    sz = new int[n + 1];
    set = new int[n + 1];
    c = new int[n + 1];
    for (int i = 0; i < n + 1; ++i) {
        g[i] = new ArrayList<>();
    }
    int rt = 0;
    int[] a = new int[n];
    for (int i = 1; i <= n; ++i) {
        a[i - 1] = i;
        int p = ni();
        c[i] = ni();
        g[p].add(i);
        if (p == 0)
            rt = i;
    }
    go(rt);
    dfs(rt, a);
    if (!ok) {
        println("NO");
        return;
    }
    println("YES");
    printArray(set, 1);
}