public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), m = in.readInt();
    int[] lower = new int[n];
    IntList[] higher = new IntList[n];
    Arrays.setAll(higher, i -> new IntArrayList());
    int[] time = ArrayUtils.createOrder(n);
    int T = n;
    long res = 0;
    int[] A = new int[m], B = new int[m];
    in.readIntArrays(A, B);
    MiscUtils.decreaseByOne(A, B);
    for (int i = 0; i < m; i++) {
        int a = Math.min(A[i], B[i]), b = Math.max(A[i], B[i]);
        lower[b]++;
        higher[a].add(b);
    }
    for (int i = 0; i < n; i++) {
        res += (long) lower[i] * higher[i].size();
    }
    out.printLine(res);
    int q = in.readInt();
    for (int i = 0; i < q; i++) {
        int u = in.readInt() - 1;
        res -= (long) lower[u] * higher[u].size();
        for (int v : higher[u]) {
            res -= (long) lower[v] * higher[v].size();
            lower[v]--;
            higher[v].add(u);
            res += (long) lower[v] * higher[v].size();
        }
        lower[u] += higher[u].size();
        while (!higher[u].isEmpty()) {
            higher[u].removeAt(higher[u].size() - 1);
        }
        out.printLine(res);
    }
}