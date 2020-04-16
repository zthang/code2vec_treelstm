static void solve() throws IOException {
    // initIo(true);
    initIo(false);
    StringBuilder sb = new StringBuilder();
    int n = ni(), m = ni();
    edges = new ArrayList<>();
    for (int i = 0; i < m; ++i) {
        int u = ni(), v = ni();
        edges.add(new Pair(u, v));
    }
    // pl("Adjacenecy list");
    // for(int i=1;i<=n;++i) {
    // for(int  e : adj[i]) {
    // p(e);
    // }
    // pl();
    // }
    color = new int[n + 1];
    nadj = new ArrayList[n + 1];
    for (int i = 1; i <= n; ++i) {
        nadj[i] = new ArrayList<>();
    }
    color[1] = 1;
    HashSet<Integer> newSet = new HashSet<>();
    for (Pair p : edges) {
        if (p.x == 1) {
            newSet.add(p.y);
        } else if (p.y == 1) {
            newSet.add(p.x);
        }
    }
    // pl();
    for (Pair p : edges) {
        if (newSet.contains(p.x) && newSet.contains(p.y)) {
            nadj[p.x].add(p.y);
            nadj[p.y].add(p.x);
        }
    }
    // }
    for (int e : newSet) {
        if (color[e] == 0) {
            color[e] = 2;
            dfs(e);
        }
    }
    for (int i = 1; i <= n; ++i) {
        if (color[i] == 0) {
            color[i] = 1;
        }
    }
    // pl("Assigned colors : ");
    // for(int i=1;i<=n;++i) {
    // p(color[i]);
    // }
    // pl();
    int[] cnt = new int[4];
    for (int i = 1; i <= n; ++i) {
        cnt[color[i]]++;
    }
    if (cnt[1] > 0 && cnt[2] > 0 && cnt[3] > 0 && cnt[1] + cnt[2] + cnt[3] == n) {
        int[][] mat = new int[4][4];
        for (Pair p : edges) {
            mat[color[p.x]][color[p.y]]++;
            mat[color[p.y]][color[p.x]]++;
        }
        if (mat[1][1] == 0 && mat[2][2] == 0 && mat[3][3] == 0 && mat[1][2] == cnt[2] * cnt[1] && mat[2][3] == cnt[2] * cnt[3] && mat[1][3] == cnt[1] * cnt[3]) {
            for (int i = 1; i <= n; ++i) {
                p(color[i]);
            }
            pl();
        } else {
            pl(-1);
        }
    } else {
        pl(-1);
    }
    pw.flush();
    pw.close();
}