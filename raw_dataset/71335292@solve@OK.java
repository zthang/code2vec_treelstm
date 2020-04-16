void solve() throws IOException {
    int n = ni(), m = ni(), k = ni();
    ArrayList<Integer> F = new ArrayList();
    for (int x = 0; x < k; x++) F.add(ni());
    A = new ArrayList[n + 1];
    for (int x = 1; x <= n; x++) A[x] = new ArrayList();
    for (int x = 0; x < m; x++) {
        int u = ni(), v = ni();
        A[u].add(v);
        A[v].add(u);
    }
    B = new int[n + 1];
    Arrays.fill(B, -1);
    Queue<Integer> Q = new LinkedList();
    Q.add(1);
    B[1] = 0;
    while (Q.size() > 0) {
        int v = Q.poll();
        for (int x = 0; x < A[v].size(); x++) {
            int u = A[v].get(x);
            if (B[u] > -1)
                continue;
            B[u] = B[v] + 1;
            Q.add(u);
        }
    }
    C = new int[n + 1];
    Arrays.fill(C, -1);
    Q.add(n);
    C[n] = 0;
    while (Q.size() > 0) {
        int v = Q.poll();
        for (int x = 0; x < A[v].size(); x++) {
            int u = A[v].get(x);
            if (C[u] > -1)
                continue;
            C[u] = C[v] + 1;
            Q.add(u);
        }
    }
    int[][] D = new int[F.size()][2];
    for (int x = 0; x < F.size(); x++) {
        D[x][0] = F.get(x);
        D[x][1] = B[D[x][0]];
    }
    Arrays.sort(D, (a, b) -> Integer.compare(b[1], a[1]));
    int ans = 0;
    int maxend = C[D[0][0]];
    for (int x = 1; x < F.size(); x++) {
        ans = Math.max(ans, B[D[x][0]] + maxend + 1);
        maxend = Math.max(maxend, C[D[x][0]]);
    }
    ans = Math.min(ans, B[n]);
    System.out.println(ans);
}