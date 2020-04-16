public void solve(Scanner sc, PrintWriter pw) throws IOException {
    n = sc.nextInt();
    graph = new int[n][n];
    deg = new int[n];
    cpDeg = new int[n];
    for (int i = 0; i < n; i++) {
        String s = sc.next();
        for (int j = 0; j < n; j++) {
            int y = s.charAt(j) - '0';
            if (i < j) {
                if (y == 1)
                    deg[i]++;
                if (y == 0)
                    deg[j]++;
            }
            if (y == 0 && i != j)
                y = -1;
            graph[i][j] = y;
        }
    }
    if (scc()) {
        pw.println("0 1");
        return;
    }
    // for (int i = 0; i < n; i++) {
    // if (deg[i] == 0 || deg[i] == n - 1) {
    // pw.println(-1);
    // return;
    // }
    // }
    long tot = 1;
    for (int i = 1; i <= n; i++) {
        if (System.currentTimeMillis() - TIME_START >= 1500)
            break;
        long ret = (long) dfs(i, 0) * tot % mod;
        tot = tot * (i + 1) % mod;
        if (ret > 0) {
            pw.println(i + " " + ret);
            return;
        }
    }
    pw.println(-1);
}