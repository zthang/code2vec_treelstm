void solve() {
    int n = scn.nextInt();
    int[][] arr = scn.next2DInt(n, 2);
    int[] cost = scn.nextIntArray(n);
    int[] per = scn.nextIntArray(n);
    long[][] E = new long[n * (n + 1) / 2][];
    for (int i = 0, z = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            long w = (Math.abs(arr[i][0] - arr[j][0]) + Math.abs(arr[i][1] - arr[j][1])) * 1L * (per[i] + per[j]);
            E[z++] = new long[] { i, j, w, 0 };
        }
        E[z++] = new long[] { i, n, cost[i], 0 };
    }
    Arrays.sort(E, (o1, o2) -> Long.compare(o1[2], o2[2]));
    long ans = 0;
    int stn = 0;
    DisJointSet dj = new DisJointSet(n + 1);
    for (long[] e : E) {
        int u = (int) e[0], v = (int) e[1];
        if (!dj.isSame(u, v)) {
            ans += e[2];
            dj.union(u, v);
            e[3] = 1;
            if (v == n) {
                stn++;
            }
        }
    }
    out.println(ans);
    out.println(stn);
    for (long[] e : E) {
        if (e[3] == 1 && e[1] == n) {
            out.print(e[0] + 1 + " ");
        }
    }
    out.println();
    out.println(n - stn);
    for (long[] e : E) {
        if (e[3] == 1 && e[1] != n) {
            out.println((e[0] + 1) + " " + (e[1] + 1));
        }
    }
}