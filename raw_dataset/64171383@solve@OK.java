public void solve(int testNumber, InputReader in, PrintWriter out) throws IOException {
    int t = 1;
    while (t-- > 0) {
        int n = in.nextInt();
        int[][] p = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            p[i][0] = in.nextInt();
            p[i][1] = in.nextInt();
        }
        int[] c = new int[n];
        int[] k = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = in.nextInt();
        }
        for (int j = 0; j < n; j++) {
            k[j] = in.nextInt();
        }
        long[][] edges = new long[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    long wt = 1L * (k[i - 1] + k[j - 1]) * (Math.abs(p[i][0] - p[j][0]) + Math.abs(p[i][1] - p[j][1]));
                    edges[i][j] = wt;
                    edges[j][i] = wt;
                } else {
                    edges[i][0] = c[i - 1];
                    edges[0][i] = c[i - 1];
                }
            }
        }
        int V = n + 1;
        // System.out.println(n+" "+V);
        int[] parent = new int[V];
        long[] key = new long[V];
        Boolean[] mstSet = new Boolean[V];
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
        key[0] = 0;
        parent[0] = -1;
        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet, V);
            mstSet[u] = true;
            for (int v = 0; v < V; v++) if (u != v && mstSet[v] == false && edges[u][v] < key[v]) {
                parent[v] = u;
                key[v] = edges[u][v];
            }
        }
        ArrayList<Integer> res1 = new ArrayList<Integer>();
        ArrayList<Integer> res2 = new ArrayList<Integer>();
        long res = 0;
        for (int i = 1; i < V; i++) {
            // System.out.println(i+" "+parent[i]);
            res += edges[i][parent[i]];
            if (parent[i] == 0) {
                res1.add(i);
            } else {
                res2.add(i);
                res2.add(parent[i]);
            }
        }
        out.println(res);
        out.println(res1.size());
        int sz1 = res1.size();
        int sz2 = res2.size();
        for (int i = 0; i < sz1; i++) {
            out.print(res1.get(i) + " ");
        }
        out.println();
        out.println(sz2 / 2);
        for (int i = 0; i < sz2; i += 2) {
            out.print(res2.get(i) + " " + res2.get(i + 1));
            out.println();
        }
    }
}