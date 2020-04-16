    void run() throws IOException {
        int n = nextInt();
        int m = nextInt();
        count = new int[4];
        col = new int[n];
        was = new boolean[n];
        edges = new int[4][4];
        graph = new ArrayList[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int from = nextInt() - 1;
            int to = nextInt() - 1;
            graph[from].add(to);
            graph[to].add(from);
        }
        col[0] = 1;
        for (Integer c : graph[0]) {
            col[c] = -1;
        }
        for (int i = 0; i < col.length; i++) {
            if (col[i] == -1) continue;
            col[i] = 1;
            count[i]++;
        }
        for (int i = 0; i < was.length; i++) {
            if (!was[i]) {
                dfs(i, 1);
            }
        }
        for (int i = 0; i < col.length; i++) {
            count[col[i]]++;
        }
        was = new boolean[n];
        for (int i = 0; i < was.length; i++) {
            if (!was[i]) countedges(i, 1);
        }
        int sum = edges[1][2] + edges[2][3] + edges[3][1];
        if (edges[1][2] != count[1] * count[2] || edges[1][3] != count[1] * count[3] || edges[2][3] != count[2] * count[3] || sum != m)
            pw.print(-1);
        else {
            for (int i = 0; i < col.length; i++) {
                pw.print(col[i] + " ");
            }
        }
        pw.close();
    }