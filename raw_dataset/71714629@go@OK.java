void go(int pos) {
    if (pos == 0) {
        p[0] = 0;
        go(pos + 1);
        return;
    }
    if (pos == k >> 1) {
        p[pos] = 0;
        for (int i = 0; i < k >> 1; i++) {
            used[p[i]] = true;
        }
        int cur = 0;
        for (int i = 0; i < k >> 1; i++) {
            int u = p[i], v = p[i + 1];
            int[] curV = bestV[u][v];
            int ind = 0;
            while (used[curV[ind]]) {
                ind++;
            }
            cur += bestCost[u][v][ind];
        }
        bestAns = Math.min(bestAns, cur);
        for (int i = 0; i < k >> 1; i++) {
            used[p[i]] = false;
        }
        return;
    }
    for (int i = 0; i < n; i++) {
        p[pos] = i;
        go(pos + 1);
    }
}