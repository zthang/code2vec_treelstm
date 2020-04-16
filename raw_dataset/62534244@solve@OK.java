void solve() {
    int n = ni();
    int[][] cs = new int[3][];
    for (int i = 0; i < 3; i++) cs[i] = na(n);
    int[] from = new int[n - 1];
    int[] to = new int[n - 1];
    for (int i = 0; i < n - 1; i++) {
        from[i] = ni() - 1;
        to[i] = ni() - 1;
    }
    int[][] g = packU(n, from, to);
    int L = -1;
    for (int i = 0; i < n; i++) {
        if (g[i].length > 2) {
            out.println(-1);
            return;
        } else if (g[i].length == 1) {
            L = i;
        }
    }
    int[] ord = new int[n];
    ord[0] = L;
    for (int i = 1; i < n; i++) {
        if (g[ord[i - 1]].length == 1) {
            ord[i] = g[ord[i - 1]][0];
        } else {
            ord[i] = g[ord[i - 1]][0] ^ g[ord[i - 1]][1] ^ ord[i - 2];
        }
    }
    long min = Long.MAX_VALUE;
    int[] color = null;
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (i == j)
                continue;
            long sum = 0;
            for (int k = 0; k < n; k++) {
                sum += cs[k % 3 == 0 ? i : k % 3 == 1 ? j : 3 ^ i ^ j][ord[k]];
            }
            if (sum < min) {
                min = sum;
                color = new int[n];
                for (int k = 0; k < n; k++) {
                    color[ord[k]] = (k % 3 == 0 ? i : k % 3 == 1 ? j : 3 ^ i ^ j) + 1;
                }
            }
        }
    }
    out.println(min);
    for (int v : color) {
        out.print(v + " ");
    }
}