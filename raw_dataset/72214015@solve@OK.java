void solve(int TC) throws Exception {
    int n = ni(), m = ni();
    int[] from = new int[m], to = new int[m];
    for (int i = 0; i < m; i++) {
        from[i] = ni() - 1;
        to[i] = ni() - 1;
    }
    int[][] gr = make(n, to, from);
    int k = ni();
    int[] path = new int[k];
    for (int i = 0; i < k; i++) path[i] = ni() - 1;
    int t = path[k - 1];
    int[] d = new int[n];
    Arrays.fill(d, 2 * n);
    d[t] = 0;
    TreeSet<Integer>[] nxt = new TreeSet[n];
    for (int i = 0; i < n; i++) nxt[i] = new TreeSet<>();
    int[] ord = new int[n];
    int c = 0;
    ord[c++] = t;
    boolean[] add = new boolean[n];
    add[t] = true;
    for (int i = 0; i < c; i++) {
        for (int v : gr[ord[i]]) {
            if (!add[v]) {
                ord[c++] = v;
                add[v] = true;
            }
            if (d[v] > d[ord[i]] + 1) {
                d[v] = d[ord[i]] + 1;
                nxt[v] = new TreeSet<>();
            }
            if (d[v] == d[ord[i]] + 1)
                nxt[v].add(ord[i]);
        }
    }
    int min = 0, max = 0;
    for (int i = k - 2; i >= 0; i--) {
        if (!nxt[path[i]].contains(path[i + 1]))
            min++;
        if (nxt[path[i]].size() > 1 || !nxt[path[i]].contains(path[i + 1]))
            max++;
    }
    pn(min + " " + max);
}