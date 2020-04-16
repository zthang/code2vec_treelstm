int go(int curVertex) {
    if (curVertex == g.length) {
        int curRes = 0;
        for (int i = 0; i < curVertex; i++) {
            for (int j = i + 1; j < curVertex; j++) {
                int u = Math.min(id[i], id[j]);
                int v = Math.max(id[i], id[j]);
                if (g[i][j] && !used[u][v]) {
                    used[u][v] = true;
                    curRes++;
                }
            }
        }
        for (int i = 0; i < 6; i++) {
            Arrays.fill(used[i], false);
        }
        return curRes;
    }
    int r = 0;
    for (int i = 0; i < 6; i++) {
        id[curVertex] = i;
        r = Math.max(r, go(curVertex + 1));
    }
    return r;
}