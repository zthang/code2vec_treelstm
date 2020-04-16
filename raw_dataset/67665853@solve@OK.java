public final void solve(int testNumber, InputReader in, PrintWriter out) {
    int n = in.nextInt();
    int[] a = in.nextIntArrayOneBased(n);
    int[][] e = new int[n << 1][];
    int pt = 0;
    for (int i = 1; i <= n; i++) {
        if (i - a[i] >= 1) {
            e[pt++] = new int[] { i - a[i], i };
        }
        if (i + a[i] <= n) {
            e[pt++] = new int[] { i + a[i], i };
        }
    }
    e = Arrays.copyOf(e, pt);
    int[][] t = GraphUtils.packDirectedUnweighted(e, n);
    int[] ans = new int[n + 1];
    Arrays.fill(ans, Constants.INF32);
    for (int j = 0; j < 2; j++) {
        int[] queue = new int[n + 1];
        int[] dist = new int[n + 1];
        int addPt = 0, pollPt = 0;
        for (int i = 1; i <= n; i++) {
            if (a[i] % 2 != j) {
                queue[addPt++] = i;
            }
        }
        while (addPt > pollPt) {
            int u = queue[pollPt++];
            for (int v : t[u]) {
                if (a[v] % 2 == j && dist[v] == 0) {
                    ans[v] = dist[v] = dist[u] + 1;
                    queue[addPt++] = v;
                }
            }
        }
    }
    for (int i = 1; i <= n; i++) {
        if (ans[i] == Constants.INF32) {
            out.print("-1");
        } else {
            out.print(ans[i]);
        }
        out.print(" ");
    }
}