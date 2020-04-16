void solve() throws IOException {
    n = ni();
    m = ni();
    A = new ArrayList[n + 1];
    B = new ArrayList[n + 1];
    C = new ArrayList[n + 1];
    for (int x = 1; x <= n; x++) {
        A[x] = new ArrayList();
        B[x] = new ArrayList();
        C[x] = new ArrayList();
    }
    for (int x = 1; x <= m; x++) {
        int p = ni(), q = ni();
        A[p].add(q);
        B[p].add(x);
        C[p].add(1);
    }
    int c = 1;
    while (!dfs(c)) c++;
    int[] E = new int[m + 1];
    for (int x = 1; x <= n; x++) {
        for (int y = 0; y < A[x].size(); y++) {
            E[B[x].get(y)] = C[x].get(y);
        }
    }
    System.out.println(c);
    for (int x = 1; x <= m; x++) out.print(E[x] + " ");
    out.println();
    out.flush();
}