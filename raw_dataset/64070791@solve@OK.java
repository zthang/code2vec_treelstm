public void solve(int testNumber, InputReader c, OutputWriter w) {
    int n = c.readInt(), m = c.readInt();
    HashSet<Integer>[] ad = new HashSet[n];
    ArrayList<Integer>[] adj = new ArrayList[n];
    for (int i = 0; i < n; i++) {
        ad[i] = new HashSet<>();
        adj[i] = new ArrayList<>();
    }
    for (int i = 0; i < m; i++) {
        int u = c.readInt() - 1, v = c.readInt() - 1;
        ad[v].add(u);
        ad[u].add(v);
    }
    int[] res = new int[n];
    int cnt = 1;
    isp = true;
    for (int i = 0; i < n && cnt <= 3; i++) {
        if (res[i] != 0) {
            continue;
        }
        for (int j = 0; j < n; j++) {
            if (!ad[i].contains(j)) {
                if (res[j] == 0) {
                    res[j] = cnt;
                } else {
                    isp = false;
                }
            }
        }
        cnt++;
    }
    if (cnt < 4 || !isp) {
        w.printLine(-1);
        return;
    }
    long[] cntt = new long[4];
    HashSet<Integer>[] che = new HashSet[3];
    for (int i = 0; i < 3; i++) {
        che[i] = new HashSet<>();
    }
    for (int i = 0; i < n; i++) {
        if (res[i] == 0) {
            w.printLine(-1);
            return;
        }
        cntt[res[i]]++;
        che[res[i] - 1].add(i);
    }
    // w.printLine(cntt);
    boolean[] vis = new boolean[n];
    if (dfs(0, res, ad, vis, che)) {
        long mt = cntt[3] * cntt[1] + cntt[1] * cntt[2] + cntt[2] * cntt[3];
        if (isp && mt == m) {
            w.printLine(res);
        } else {
            w.printLine(-1);
        }
    } else {
        w.printLine(-1);
    }
}