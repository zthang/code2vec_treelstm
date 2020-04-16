public void run() {
    try {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.ni();
        int m = in.ni();
        g = new ArrayList[n + 1];
        lev = new int[n + 1];
        pre = new int[n + 1];
        post = new int[n + 1];
        par = new int[n + 1];
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            int u = in.ni();
            int v = in.ni();
            g[u].add(v);
            g[v].add(u);
        }
        dfs(1, 0, 0);
        par[1] = 1;
        for (int q = 1; q <= m; q++) {
            int k = in.ni();
            ArrayList<Integer> al = new ArrayList<>();
            for (int i = 1; i <= k; i++) al.add(par[in.ni()]);
            int max = al.get(0);
            for (int i : al) {
                if (lev[i] > lev[max])
                    max = i;
            }
            int kk = 0;
            for (int i : al) {
                if (pre[i] <= pre[max] && post[i] >= post[max])
                    continue;
                kk = 1;
                break;
            }
            if (kk == 0)
                out.println("YES");
            else
                out.println("NO");
        }
        out.close();
    } catch (Exception e) {
        System.out.println(e);
    }
}