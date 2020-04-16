static void solve(FastIO io) {
    int n = io.nextInt();
    int m = io.nextInt();
    int a = io.nextInt() - 1;
    int b = io.nextInt() - 1;
    adj = new ArrayList<>();
    int[] edges = new int[n];
    for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
    for (int i = 0; i < m; i++) {
        int u = io.nextInt() - 1;
        int v = io.nextInt() - 1;
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    int[] compA = new int[n];
    comp = 1;
    for (int i = 0; i < n; i++) if (compA[i] == 0 && i != a) {
        dfs(i, compA, a);
        comp++;
    }
    int[] compB = new int[n];
    comp = 1;
    for (int i = 0; i < n; i++) if (compB[i] == 0 && i != b) {
        dfs(i, compB, b);
        comp++;
    }
    long ttlA = 0, ttlB = 0;
    for (int i = 0; i < n; i++) {
        if (i == a || i == b)
            continue;
        if (compA[i] != compA[b])
            ttlA++;
        if (compB[i] != compB[a])
            ttlB++;
    }
    io.println(ttlA * ttlB);
}