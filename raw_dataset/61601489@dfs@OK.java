void dfs(int v) {
    was[v] = true;
    for (Integer e : graph[v]) {
        if (col[v] == col[e]) {
            pw.println(-1);
            pw.close();
            System.exit(0);
        }
        if (!was[e] && col[e] == -1) {
            if (col[v] == 1 || col[v] == 3)
                col[e] = 2;
            else
                col[e] = 3;
            dfs(e);
        }
    }
}