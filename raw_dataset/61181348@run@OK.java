public void run() {
    FastScanner fs = new FastScanner();
    PrintWriter out = new PrintWriter(System.out);
    System.err.println("");
    int n = fs.nextInt();
    int m = fs.nextInt();
    int[][] adj = readGraph(n, m, fs);
    ArrayDeque<Integer>[] inIdx = new ArrayDeque[n];
    for (int i = 0; i < n; i++) {
        inIdx[i] = new ArrayDeque<>();
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < adj[i].length; j++) {
            int v = adj[i][j];
            if (v > i) {
                inIdx[i].add(v);
            }
        }
    }
    long[] contribs = new long[n];
    for (int i = 0; i < n; i++) {
        for (int v : adj[i]) {
            if (i > v) {
                contribs[i] += adj[v].length - inIdx[v].size();
            }
        }
    }
    long curRes = 0;
    for (long i : contribs) curRes += i;
    out.println(curRes);
    int q = fs.nextInt();
    for (int qq = 1; qq <= q; qq++) {
        int change = fs.nextInt() - 1;
        // all my inIdx's will clear out
        int oldOut = adj[change].length - inIdx[change].size();
        while (!inIdx[change].isEmpty()) {
            int v = inIdx[change].pollFirst();
            contribs[v] -= inIdx[v].size() + oldOut;
            curRes -= inIdx[v].size() + oldOut;
            inIdx[v].add(change);
            int add = adj[v].length - inIdx[v].size();
            contribs[change] += add;
            curRes += add;
        }
        out.println(curRes);
    }
    out.close();
}