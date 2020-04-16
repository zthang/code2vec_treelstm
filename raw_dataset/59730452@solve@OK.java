void solve() {
    int n = scn.nextInt(), m = scn.nextInt();
    int[] from = new int[n - 1], to = new int[n - 1], w = new int[n - 1];
    int[][] edge = new int[n - 1][3];
    for (int i = 0; i < n - 1; i++) {
        from[i] = edge[i][0] = scn.nextInt() - 1;
        to[i] = edge[i][1] = scn.nextInt() - 1;
        w[i] = edge[i][2] = scn.nextInt();
    }
    Arrays.parallelSort(edge, (o1, o2) -> o1[2] - o2[2]);
    int[][] q = new int[m][];
    for (int i = 0; i < m; i++) {
        q[i] = new int[] { scn.nextInt(), i };
    }
    Arrays.parallelSort(q, (o1, o2) -> o1[0] - o2[0]);
    long[] ans = new long[m];
    DisJointSet dj = new DisJointSet(n);
    long a = 0;
    for (int i = 0, j = 0; i < m; i++) {
        while (j < edge.length && edge[j][2] <= q[i][0]) {
            int x = edge[j][0], y = edge[j][1];
            int s1 = dj.count[dj.root(x)];
            int s2 = dj.count[dj.root(y)];
            dj.union(x, y);
            a -= s1 * 1L * (s1 - 1) / 2;
            a -= s2 * 1L * (s2 - 1) / 2;
            int s = dj.count[dj.root(x)];
            a += s * 1L * (s - 1) / 2;
            j++;
        }
        ans[q[i][1]] = a;
    }
    for (long x : ans) {
        out.print(x + " ");
    }
    out.println();
}