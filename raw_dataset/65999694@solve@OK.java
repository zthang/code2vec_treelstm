@SuppressWarnings("unchecked")
void solve(int testNumber, FastScanner s, PrintWriter out) {
    N = s.nextInt();
    A = s.nextInt();
    parA = new int[A];
    depA = new int[A];
    connA = new int[N + 1];
    Arrays.setAll(adjA = new ArrayList[A], x -> new ArrayList<>());
    for (int u = 1, v; u < A; u++) {
        v = s.nextInt() - 1;
        adjA[u].add(v);
        adjA[v].add(u);
    }
    for (int x = 1; x <= N; x++) connA[x] = s.nextInt() - 1;
    B = s.nextInt();
    parB = new int[B];
    depB = new int[B];
    connB = new int[N + 1];
    Arrays.setAll(adjB = new ArrayList[B], x -> new ArrayList<>());
    for (int u = 1, v; u < B; u++) {
        v = s.nextInt() - 1;
        adjB[u].add(v);
        adjB[v].add(u);
    }
    for (int x = 1; x <= N; x++) connB[x] = s.nextInt() - 1;
    dfs(0, adjA, -1, parA, 0, depA);
    dfs(0, adjB, -1, parB, 0, depB);
    for (int[] row : lcaA = new int[A][A]) Arrays.fill(row, -1);
    for (int[] row : lcaB = new int[B][B]) Arrays.fill(row, -1);
    for (int i = 0; i < A; i++) for (int j = 0; j < A; j++) lcaA(i, j);
    for (int i = 0; i < B; i++) for (int j = 0; j < B; j++) lcaB(i, j);
    memo = new int[2][N + 1][N + 1];
    for (int[][] a : memo) for (int[] b : a) Arrays.fill(b, -1);
    int best = min(dp(0, 1, 1), dp(1, 1, 1));
    out.println(A + B - 2 - best);
}