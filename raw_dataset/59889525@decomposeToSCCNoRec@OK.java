public static int[] decomposeToSCCNoRec(int[][] g) {
    int n = g.length;
    int[] stack = new int[n + 1];
    int[] ind = new int[n + 1];
    int[] ord = new int[n];
    Arrays.fill(ord, -1);
    int[] low = new int[n];
    Arrays.fill(low, -1);
    int sp = 0;
    // preorder
    int id = 0;
    int[] clus = new int[n];
    int cid = 0;
    int[] cstack = new int[n + 1];
    int csp = 0;
    boolean[] incstack = new boolean[n];
    for (int i = 0; i < n; i++) {
        if (ord[i] == -1) {
            ind[sp] = 0;
            cstack[csp++] = i;
            stack[sp++] = i;
            incstack[i] = true;
            while (sp > 0) {
                int cur = stack[sp - 1];
                if (ind[sp - 1] == 0) {
                    ord[cur] = low[cur] = id++;
                }
                if (ind[sp - 1] < g[cur].length) {
                    int nex = g[cur][ind[sp - 1]];
                    if (ord[nex] == -1) {
                        ind[sp - 1]++;
                        ind[sp] = 0;
                        incstack[nex] = true;
                        cstack[csp++] = nex;
                        stack[sp++] = nex;
                    } else {
                        // low is ok too, but slower.
                        if (incstack[nex])
                            low[cur] = Math.min(low[cur], ord[nex]);
                        ind[sp - 1]++;
                    }
                } else {
                    if (ord[cur] == low[cur]) {
                        while (csp > 0) {
                            incstack[cstack[csp - 1]] = false;
                            clus[cstack[--csp]] = cid;
                            if (cstack[csp] == cur)
                                break;
                        }
                        cid++;
                    }
                    if (--sp >= 1)
                        low[stack[sp - 1]] = Math.min(low[stack[sp - 1]], low[stack[sp]]);
                }
            }
        }
    }
    return clus;
}