void solve(int TC) throws Exception {
    int n = ni(), m = ni();
    int[][] e = new int[m][];
    for (int i = 0; i < m; i++) e[i] = new int[] { ni() - 1, ni() - 1 };
    int[] set = new int[n];
    for (int i = 0; i < n; i++) set[i] = i;
    int[][] g = makeU(n, e);
    int arg = 0;
    for (int i = 0; i < n; i++) if (g[i].length < g[arg].length)
        arg = i;
    Arrays.sort(g[arg]);
    for (int i = 0; i < n; i++) if (Arrays.binarySearch(g[arg], i) < 0)
        set[find(set, i)] = find(set, arg);
    for (int x : g[arg]) {
        Arrays.sort(g[x]);
        for (int i = 0; i < n; i++) if (Arrays.binarySearch(g[x], i) < 0)
            set[find(set, i)] = find(set, x);
    }
    int count = 0;
    int[] mp = new int[n];
    Arrays.fill(mp, -1);
    for (int i = 0; i < n; i++) if (find(set, i) == i)
        mp[i] = ++count;
    boolean valid = true;
    for (int[] i : e) if (find(set, i[0]) == find(set, i[1]))
        valid = false;
    if (!valid || count != 3)
        pn(-1);
    else {
        for (int i = 0; i < n; i++) p(mp[find(set, i)] + " ");
        pn("");
    }
}