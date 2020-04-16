public void run() {
    FastScanner fs = new FastScanner();
    PrintWriter out = new PrintWriter(System.out);
    System.err.println("");
    int totalCost = 0;
    cycles = new ArrayList<>();
    int n = fs.nextInt();
    int m = fs.nextInt();
    int[] deg = new int[n];
    int[][] es = new int[m][3];
    for (int i = 0; i < m; i++) {
        es[i][0] = fs.nextInt() - 1;
        es[i][1] = fs.nextInt() - 1;
        deg[es[i][0]]++;
        deg[es[i][1]]++;
        es[i][2] = fs.nextInt();
    }
    adj = new int[n][];
    adjW = new int[n][];
    for (int i = 0; i < n; i++) {
        adj[i] = new int[deg[i]];
        adjW[i] = new int[deg[i]];
        deg[i] = 0;
    }
    for (int i = 0; i < m; i++) {
        int u = es[i][0];
        int v = es[i][1];
        int we = es[i][2];
        totalCost ^= we;
        adj[u][deg[u]] = v;
        adjW[u][deg[u]] = we;
        deg[u]++;
        adj[v][deg[v]] = u;
        adjW[v][deg[v]] = we;
        deg[v]++;
    }
    par = new int[n];
    weights = new int[n];
    onCycle = new int[n];
    for (int i = 0; i < n; i++) {
        if (onCycle[i] == 0) {
            sPtr = 0;
            dfs(i, -1);
        }
    }
    int[] curWays = null;
    int[] numWays = null;
    for (int i = 0; i < cycles.size(); i++) {
        int[] nxt = new int[SIZE];
        int[] nxt2 = new int[SIZE];
        IntList curCycle = cycles.get(i);
        for (int ii = 0; ii < curCycle.size(); ii++) {
            int x = curCycle.get(ii);
            nxt2[x] = 1;
            nxt[x]++;
        }
        if (curWays == null) {
            curWays = nxt;
            numWays = nxt2;
        } else {
            curWays = multXOR(curWays, nxt, true);
            numWays = multXOR(numWays, nxt2, false);
        }
    }
    int min = Integer.MAX_VALUE;
    int ways = 1;
    for (int i = 0; i < curWays.length; i++) {
        if (numWays[i] == 0)
            continue;
        int gets = totalCost ^ i;
        if (gets <= min) {
            if (gets < min) {
                min = gets;
                ways = curWays[i];
            } else {
                ways = add(ways, curWays[i]);
            }
        }
    }
    out.println(min + " " + ways);
    out.close();
}