    static void solve() throws IOException {
        n = sc.nextInt();
        int m = sc.nextInt();
        gr = new ArrayList[n];
        for(int i = 0;i < n;i++) gr[i] = new ArrayList<>();
        used = new int[n];
        col = new int [m];
        for(int i = 0;i < m;i++) {
            int v1 = sc.nextInt() - 1;
            int v2 = sc.nextInt() - 1;
            gr[v1].add(new edge(v2, i));
        }

        for(int i = 0;i < n;i++) if (used[i] == 0) dfs(i);

        int ans = 0;
        for(int i = 0;i < n;i++) ans = Math.max(ans, col[i]);
        pw.println(ans);
        for(int i = 0;i < m;i++) pw.print(col[i] + " ");
    }