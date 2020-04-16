public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    int m = in.readInt();
    int[] a = new int[m];
    int[] b = new int[m];
    in.readIntArrays(a, b);
    MiscUtils.decreaseByOne(a, b);
    IndependentSetSystem dsu = new ListIndependentSetSystem(n);
    for (int i = 0; i < m; i++) {
        dsu.join(a[i], b[i]);
    }
    int[] from = ArrayUtils.createArray(n, n);
    int[] to = ArrayUtils.createArray(n, -1);
    for (int i = 0; i < n; ++i) {
        from[dsu.get(i)] = Math.min(from[dsu.get(i)], i);
        to[dsu.get(i)] = Math.max(to[dsu.get(i)], i);
    }
    ArrayUtils.orderBy(from, to);
    int end = -1;
    int numParts = 0;
    for (int i = 0; i < n; i++) {
        if (from[i] == n) {
            break;
        }
        if (from[i] > end) {
            numParts++;
        }
        end = Math.max(end, to[i]);
    }
    out.printLine(dsu.getSetCount() - numParts);
}