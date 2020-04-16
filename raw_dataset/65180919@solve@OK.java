public void solve(int testNumber, InputReader sc, PrintWriter out) {
    int n = sc.nextInt();
    int m = sc.nextInt();
    par = new int[n];
    max = new int[n];
    for (int i = 0; i < n; ++i) {
        par[i] = i;
        max[i] = i;
    }
    for (int i = 0; i < m; ++i) {
        int u = sc.nextInt() - 1;
        int v = sc.nextInt() - 1;
        union(u, v);
    }
    int ans = 0;
    int ptr = 0;
    while (ptr < n) {
        int curInd = ptr;
        int maxRange = max[findSet(curInd)];
        while (curInd <= maxRange) {
            if (findSet(curInd) != findSet(ptr)) {
                union(curInd, ptr);
                ans++;
                maxRange = max[findSet(curInd)];
            }
            curInd++;
        }
        ptr = curInd;
    }
    out.print(ans);
}