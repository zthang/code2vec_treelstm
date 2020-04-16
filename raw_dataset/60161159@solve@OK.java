public void solve(int testNumber, InputReader sc, PrintWriter out) {
    int n = sc.nextInt();
    int m = sc.nextInt();
    ArrayList<Integer>[] edge = new ArrayList[n + 1];
    int[] d = new int[n + 1];
    for (int i = 1; i <= n; i++) edge[i] = new ArrayList<Integer>();
    int[] x = new int[m];
    int[] y = new int[m];
    for (int i = 0; i < m; i++) {
        int u = sc.nextInt();
        int v = sc.nextInt();
        x[i] = u;
        y[i] = v;
        edge[u].add(v);
        d[v]++;
    }
    if (topSort(edge, d)) {
        out.println("1");
        for (int i = 1; i <= m; i++) out.print("1 ");
        out.println();
        return;
    }
    out.println("2");
    for (int i = 0; i < m; i++) {
        if (x[i] < y[i])
            out.print("1 ");
        else
            out.print("2 ");
    }
    out.println();
}