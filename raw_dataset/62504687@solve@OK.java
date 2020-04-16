public void solve(int testNumber, InputReader sc, PrintWriter out) throws IOException {
    int n = sc.nextInt();
    ArrayList<Integer>[] edge = new ArrayList[n + 1];
    long[][] c = new long[3][n + 1];
    for (int i = 1; i <= n; i++) c[0][i] = sc.nextLong();
    for (int i = 1; i <= n; i++) c[1][i] = sc.nextLong();
    for (int i = 1; i <= n; i++) c[2][i] = sc.nextLong();
    for (int i = 0; i <= n; i++) edge[i] = new ArrayList<Integer>();
    for (int i = 0; i < n - 1; i++) {
        int u = sc.nextInt();
        int v = sc.nextInt();
        edge[u].add(v);
        edge[v].add(u);
    }
    ArrayList<Integer> root = new ArrayList<Integer>();
    for (int i = 1; i <= n; i++) {
        if (edge[i].size() > 2) {
            out.println("-1");
            return;
        }
        if (edge[i].size() == 1)
            root.add(i);
    }
    long ans = Long.MAX_VALUE;
    String[] f = new String[] { "123", "132", "213", "231", "312", "321" };
    ArrayList<Integer> path = bfs(root.get(0), n, edge);
    int res = -1;
    for (int i = 0; i < 6; i++) {
        long temp = 0;
        for (int j = 0; j < path.size(); j++) {
            // System.out.print(path.get(j)+" ");
            temp += c[f[i].charAt(j % 3) - '0' - 1][path.get(j)];
        }
        // System.out.println();
        if (temp < ans) {
            res = i;
            ans = temp;
        }
    }
    int[] buc = new int[n + 1];
    for (int i = 0; i < path.size(); i++) {
        buc[path.get(i)] = f[res].codePointAt(i % 3) - '0';
    }
    out.println(ans);
    for (int i = 1; i <= n; i++) out.print(buc[i] + " ");
    out.println();
}