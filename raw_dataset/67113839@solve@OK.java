private long[][] solve(int n, int m, int[] u, int[] v, int[] d) {
    long[] sum = new long[n];
    for (int i = 0; i < m; i++) {
        sum[u[i]] += d[i];
        sum[v[i]] -= d[i];
    }
    int poscnt = 0;
    int negcnt = 0;
    for (int i = 0; i < n; i++) {
        if (sum[i] > 0) {
            poscnt++;
        }
        if (sum[i] < 0) {
            negcnt++;
        }
    }
    int[] pos = new int[poscnt];
    int[] neg = new int[negcnt];
    poscnt = 0;
    negcnt = 0;
    for (int i = 0; i < n; i++) {
        if (sum[i] > 0) {
            pos[poscnt++] = i;
        }
        if (sum[i] < 0) {
            neg[negcnt++] = i;
        }
    }
    List<long[]> result = new ArrayList<>();
    while (poscnt > 0) {
        poscnt--;
        if (sum[pos[poscnt]] == 0) {
            continue;
        }
        negcnt--;
        if (sum[neg[negcnt]] == 0) {
            continue;
        }
        long z = Math.min(sum[pos[poscnt]], -sum[neg[negcnt]]);
        result.add(new long[] { pos[poscnt], neg[negcnt], z });
        sum[pos[poscnt]] -= z;
        sum[neg[negcnt]] += z;
        if (sum[pos[poscnt]] != 0) {
            poscnt++;
        }
        if (sum[neg[negcnt]] != 0) {
            negcnt++;
        }
    }
    return result.toArray(new long[result.size()][]);
}