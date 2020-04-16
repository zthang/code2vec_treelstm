public void solve(int testNumber, InputReader s, PrintWriter w) {
    int n = s.nextInt();
    long[][] a = new long[3][n];
    for (int i = 0; i < 3; i++) for (int j = 0; j < n; j++) a[i][j] = s.nextLong();
    int[] level = new int[n];
    Arrays.fill(level, -1);
    ArrayList<Integer>[] adj = new ArrayList[n];
    for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
    for (int i = 0; i < n - 1; i++) {
        int u = s.nextInt() - 1, v = s.nextInt() - 1;
        adj[u].add(v);
        adj[v].add(u);
    }
    Queue<Integer> q = new LinkedList<>();
    int root = -1;
    for (int i = 0; i < n; i++) if (adj[i].size() == 1)
        root = i;
    q.add(root);
    level[root] = 0;
    boolean res = true;
    while (!q.isEmpty()) {
        int count = 0;
        int x = q.poll();
        for (int y : adj[x]) {
            if (level[y] == -1) {
                level[y] = (level[x] + 1) % 3;
                count++;
                q.add(y);
            }
        }
        if (count > 1)
            res = false;
    }
    if (!res) {
        w.println(-1);
        return;
    }
    long[][] value = new long[3][3];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < 3; j++) value[level[i]][j] += a[j][i];
    }
    long best = Long.MAX_VALUE;
    int[] x = new int[3];
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (i == j)
                continue;
            for (int k = 0; k < 3; k++) {
                if (i == k || j == k)
                    continue;
                if (best > value[0][i] + value[1][j] + value[2][k]) {
                    best = value[0][i] + value[1][j] + value[2][k];
                    x[0] = i;
                    x[1] = j;
                    x[2] = k;
                }
            }
        }
    }
    w.println(best);
    for (int i = 0; i < n; i++) w.print((x[level[i]] + 1) + " ");
    w.println();
}