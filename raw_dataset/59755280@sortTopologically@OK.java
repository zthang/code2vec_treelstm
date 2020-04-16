int[] sortTopologically(int[][] g) {
    int n = g.length;
    int[] ec = new int[n];
    for (int i = 0; i < n; i++) {
        for (int to : g[i]) ec[to]++;
    }
    int[] ret = new int[n];
    int q = 0;
    // sources
    for (int i = 0; i < n; i++) {
        if (ec[i] == 0)
            ret[q++] = i;
    }
    for (int p = 0; p < q; p++) {
        for (int to : g[ret[p]]) {
            if (--ec[to] == 0)
                ret[q++] = to;
        }
    }
    // loop
    for (int i = 0; i < n; i++) {
        if (ec[i] > 0)
            return null;
    }
    return ret;
}