void run() {
    int n = nextInt(), m = nextInt(), k = nextInt();
    boolean[] s = new boolean[n];
    for (int i = 0; i < k; i++) {
        int v = nextInt() - 1;
        s[v] = true;
    }
    List<Integer>[] g = lists(n);
    for (int e = 0; e < m; e++) {
        int u = nextInt() - 1;
        int v = nextInt() - 1;
        g[u].add(v);
        g[v].add(u);
    }
    println(solve(n, m, s, g));
}