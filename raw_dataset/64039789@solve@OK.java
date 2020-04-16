public void solve(int testNumber, Scanner in, PrintWriter out) {
    int n = in.nextInt();
    V = n + 1;
    parent = new int[V];
    int[] x = new int[n];
    int[] y = new int[n];
    for (int i = 0; i < n; i++) {
        x[i] = in.nextInt();
        y[i] = in.nextInt();
    }
    int[] c = new int[n];
    for (int i = 0; i < n; i++) {
        c[i] = in.nextInt();
    }
    long[] k = new long[n];
    for (int i = 0; i < n; i++) {
        k[i] = in.nextInt();
    }
    long[][] graph = new long[n + 1][n + 1];
    for (int i = 0; i < n; i++) {
        graph[0][i + 1] = c[i];
        graph[i + 1][0] = c[i];
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            graph[i + 1][j + 1] = (k[i] + k[j]) * (Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]));
            graph[j + 1][i + 1] = (k[i] + k[j]) * (Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]));
        }
    }
    primMST(graph);
    int count = 0;
    List<Integer> list = new ArrayList<>();
    long ans = 0;
    for (int i = 0; i < parent.length; i++) {
        if (parent[i] == 0) {
            count++;
            list.add(i);
        }
        if (parent[i] != -1) {
            ans += graph[i][parent[i]];
        }
    }
    out.println(ans);
    out.println(count);
    for (int a : list) {
        out.print(a + " ");
    }
    out.println();
    out.println(n - count);
    for (int i = 1; i < parent.length; i++) {
        if (parent[i] != 0) {
            out.println(i + " " + parent[i]);
        }
    }
}