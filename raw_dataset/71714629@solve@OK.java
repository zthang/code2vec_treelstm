public void solve(int testNumber, FastScanner in, PrintWriter out) {
    n = in.nextInt();
    k = in.nextInt();
    p = new int[k / 2 + 1];
    used = new boolean[n];
    int[][] dist = new int[n][n];
    for (int i = 0; i < n; i++) {
        dist[i] = in.nextIntArray(n);
    }
    bestV = new int[n][n][k / 2];
    bestCost = new int[n][n][k / 2];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            int[] curV = bestV[i][j];
            int[] curCost = bestCost[i][j];
            Arrays.fill(curCost, Integer.MAX_VALUE);
            for (int t = 0; t < n; t++) {
                if (t == i || t == j) {
                    continue;
                }
                int cur = dist[i][t] + dist[t][j];
                for (int pos = 0; pos < k / 2; pos++) {
                    if (cur < curCost[pos]) {
                        for (int shift = k / 2 - 1; shift > pos; shift--) {
                            curCost[shift] = curCost[shift - 1];
                            curV[shift] = curV[shift - 1];
                        }
                        curCost[pos] = cur;
                        curV[pos] = t;
                        break;
                    }
                }
            }
        }
    }
    go(0);
    out.println(bestAns);
}