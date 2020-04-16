public void run() {
    try {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.ni();
        while (t-- != 0) {
            int n = in.ni();
            int m = in.ni();
            int a = in.ni();
            int b = in.ni();
            size = new int[n + 1];
            vis = new int[n + 1];
            g = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                g[i] = new ArrayList<>();
            }
            HashSet<pair> hs = new HashSet<>();
            for (int i = 1; i <= m; i++) {
                int u = in.ni();
                int v = in.ni();
                pair p = new pair(Math.min(u, v), Math.max(u, v));
                if (hs.contains(p))
                    continue;
                hs.add(p);
                g[u].add(v);
                g[v].add(u);
            }
            Arrays.fill(size, 1);
            size[b] = -1000000000;
            dfs(a, a);
            long x = size[a];
            Arrays.fill(size, 1);
            size[a] = -1000000000;
            Arrays.fill(vis, 0);
            dfs(b, b);
            long y = size[b];
            out.println((x - 1) * (y - 1));
        }
        out.close();
    } catch (Exception e) {
        return;
    }
}