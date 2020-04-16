void go() {
    int n = ni(), m = ni();
    int a = ni() - 1, b = ni() - 1;
    int[] from = new int[m];
    int[] to = new int[m];
    int[] ws = new int[m];
    for (int i = 0; i < m; i++) {
        from[i] = ni() - 1;
        to[i] = ni() - 1;
        ws[i] = i;
    }
    int[][][] g = packWU(n, from, to, ws);
    BCDatum bcd = decomposeToBiconnectedComponents(g);
    int[][] bg = buildBlockCutTree(bcd);
    int u = bg.length;
    int[] ind = new int[n];
    Arrays.fill(ind, -1);
    int gen = bcd.ecp;
    for (int i = 0; i < n; i++) {
        if (bcd.isArtic[i]) {
            ind[i] = gen++;
        }
    }
    boolean[] done = new boolean[n];
    int[] cf = new int[n];
    for (int i = 0; i < m; i++) {
        // tr(from[i], to[i], bcd.edgeClus[0]);
        if (!bcd.isArtic[from[i]] && !done[from[i]]) {
            cf[bcd.edgeClus[i]]++;
            done[from[i]] = true;
        }
        if (!bcd.isArtic[to[i]] && !done[to[i]]) {
            cf[bcd.edgeClus[i]]++;
            done[to[i]] = true;
        }
    }
    if (bcd.isArtic[a] && bcd.isArtic[b]) {
        int[][] pars = parents3(bg, ind[a]);
        int[] par = pars[0], ord = pars[1], dep = pars[2];
        int[] des = new int[u];
        for (int i = u - 1; i >= 0; i--) {
            int cur = ord[i];
            if (cur < bcd.ecp) {
                des[cur] += cf[cur];
            } else {
                des[cur]++;
            }
            if (i > 0)
                des[par[cur]] += des[cur];
        }
        int q = ind[b];
        for (; dep[q] > 1; q = par[q]) ;
        out.println((long) (des[ind[a]] - des[q] - 1) * (des[ind[b]] - 1));
    } else {
        out.println(0);
    }
}