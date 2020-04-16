public void run() {
    try {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.ni();
        g = new ArrayList[n + 1];
        al = new ArrayList[n + 1];
        a = new int[n + 1];
        int root = 0;
        for (int i = 1; i <= n; i++) {
            al[i] = new ArrayList<>();
            g[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            int par = in.ni();
            a[i] = in.ni();
            if (par == 0) {
                root = i;
                continue;
            }
            g[par].add(i);
        }
        dfs(root);
        if (kk == 1)
            out.println("NO");
        else {
            out.println("YES");
            int[] ans = new int[n + 1];
            for (int i : al[root]) ans[i] = k++;
            for (int i = 1; i <= n; i++) out.print(ans[i] + " ");
        }
        out.close();
    } catch (Exception e) {
        System.out.println(e);
    }
}