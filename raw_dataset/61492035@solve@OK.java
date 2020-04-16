public void solve(int testNumber, ScanReader in, PrintWriter out) {
    int n = in.scanInt();
    int m = in.scanInt();
    int[] from = new int[m];
    int[] to = new int[m];
    HashSet<Long> set = new HashSet<>();
    for (int i = 0; i < m; i++) {
        from[i] = in.scanInt();
        to[i] = in.scanInt();
        set.add(getHash(from[i], to[i]));
        set.add(getHash(to[i], from[i]));
    }
    G = CodeHash.packGraph(from, to, n, m);
    HashSet<Integer> set1 = new HashSet<>();
    {
        boolean[] visited = new boolean[n + 1];
        for (int i : G[1]) {
            visited[i] = true;
        }
        for (int i = 1; i <= n; i++) if (!visited[i])
            set1.add(i);
    }
    HashSet<Integer> set2 = new HashSet<>();
    int nd = -1;
    {
        boolean[] visited = new boolean[n + 1];
        if (G[1].length == 0) {
            out.println(-1);
            return;
        }
        nd = G[1][0];
        for (int i : G[nd]) {
            visited[i] = true;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                if (set1.contains(i)) {
                    out.println(-1);
                    return;
                }
                set2.add(i);
            }
        }
    }
    HashSet<Integer> set3 = new HashSet<>();
    int nd1 = -1;
    {
        boolean[] visited = new boolean[n + 1];
        for (int i : G[nd]) {
            if (set1.contains(i))
                continue;
            if (set2.contains(i))
                throw new RuntimeException("NO");
            nd1 = i;
            break;
        }
        if (nd1 == -1) {
            out.println(-1);
            return;
        }
        for (int i : G[nd1]) {
            visited[i] = true;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                if (set1.contains(i) || set2.contains(i)) {
                    out.println(-1);
                    return;
                }
                set3.add(i);
            }
        }
    }
    long sz1 = set1.size();
    long sz2 = set2.size();
    long sz3 = set3.size();
    if (sz1 * sz2 + sz2 * sz3 + sz1 * sz3 != m) {
        out.println(-1);
        return;
    }
    for (int i : set1) {
        for (int j : set2) {
            if (!set.contains(getHash(i, j))) {
                out.println(-1);
                return;
            }
        }
    }
    for (int i : set2) {
        for (int j : set3) {
            if (!set.contains(getHash(i, j))) {
                out.println(-1);
                return;
            }
        }
    }
    for (int i : set1) {
        for (int j : set3) {
            if (!set.contains(getHash(i, j))) {
                out.println(-1);
                return;
            }
        }
    }
    if (sz1 + sz2 + sz3 != n) {
        out.println(-1);
        return;
    }
    int[] ans = new int[n + 1];
    for (int i : set1) ans[i] = 1;
    for (int i : set2) ans[i] = 2;
    for (int i : set3) ans[i] = 3;
    for (int i = 1; i <= n; i++) {
        if (ans[i] == 0) {
            out.println(-1);
            return;
        }
    }
    for (int i = 1; i <= n; i++) out.print(ans[i] + " ");
}