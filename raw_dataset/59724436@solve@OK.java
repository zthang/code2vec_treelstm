public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), m = in.readInt();
    int[] U = new int[n - 1], V = new int[n - 1], W = new int[n - 1];
    in.readIntArrays(U, V, W);
    MiscUtils.decreaseByOne(U, V);
    int[] order = ArrayUtils.order(W);
    long[] joined = new long[n - 1];
    ListIndependentSetSystem iss = new ListIndependentSetSystem(n);
    for (int i = 0; i < n - 1; i++) {
        int u = iss.get(U[order[i]]), v = iss.get(V[order[i]]);
        if (u == v) {
            continue;
        }
        long res = (long) iss.getSize(u) * iss.getSize(v);
        iss.join(u, v);
        joined[i] = res;
    }
    long[] psum = ArrayUtils.partialSums(joined);
    for (int i = 0; i < m; i++) {
        int q = in.readInt(), pos = (int) MiscUtils.binarySearch(0, n - 1, x -> x == n - 1 || W[order[(int) x]] > q);
        long res = psum[pos];
        out.print(res, "");
    }
    out.printLine();
}