public void solve(int testNumber, InputReader c, OutputWriter w) {
    int n = c.readInt();
    int[][] a = new int[3][];
    for (int i = 0; i < 3; i++) {
        a[i] = c.readIntArray(n);
    }
    ArrayList<Integer>[] adj = new ArrayList[n];
    for (int i = 0; i < n; i++) {
        adj[i] = new ArrayList<>();
    }
    for (int i = 0; i < n - 1; i++) {
        int u = c.readInt() - 1, v = c.readInt() - 1;
        adj[u].add(v);
        adj[v].add(u);
    }
    int start = -1;
    for (int i = 0; i < n; i++) {
        if (adj[i].size() >= 3) {
            w.printLine("-1");
            return;
        } else if (adj[i].size() == 1) {
            start = i;
        }
    }
    int[] seq = new int[n];
    dfs(start, adj, seq, -1, 0);
    // w.printLine(seq);
    long bestAns = Long.MAX_VALUE;
    int[] per = { 0, 1, 2 };
    int[] ans = new int[3];
    for (int i = 0; i < 6; i++) {
        long curAns = 0;
        for (int j = 0; j < n; j++) {
            curAns += a[per[j % 3]][seq[j]];
        }
        if (bestAns > curAns) {
            bestAns = curAns;
            ans = per.clone();
        }
        Utils.nextPermutation(per);
    // w.printLine(per);
    }
    w.printLine(bestAns);
    int[] res = new int[n];
    for (int i = 0; i < n; i++) {
        res[seq[i]] = ans[i % 3];
    }
    for (int i = 0; i < n; i++) {
        w.print(res[i] + 1 + " ");
    }
    w.printLine();
}