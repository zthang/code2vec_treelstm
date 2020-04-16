static void dfs(int v) {
    for (int u : g[v]) {
        if (depth[u] == -1) {
            depth[u] = depth[v] + 1;
            p[u] = v;
            dfs(u);
        } else if (depth[v] - depth[u] + 1 >= sq) {
            out.println(2);
            out.println(depth[v] - depth[u] + 1);
            while (true) {
                out.print((v + 1) + " ");
                if (v == u)
                    break;
                v = p[v];
            }
            out.println();
            out.close();
            System.exit(0);
        }
    }
    if (set[v]) {
        for (int u : g[v]) {
            set[u] = false;
        }
    }
}