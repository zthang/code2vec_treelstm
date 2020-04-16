public void solve(int testNumber, InputReader c, OutputWriter w) {
    int n = c.readInt(), m = c.readInt();
    aa = new ArrayList[n];
    hs = new int[n];
    dd = new int[n];
    for (int i = 0; i < n; i++) {
        aa[i] = new ArrayList<>();
    }
    for (int i = 0; i < m; i++) {
        int u = c.readInt() - 1;
        int v = c.readInt() - 1;
        aa[v].add(u);
    }
    vis = new boolean[n];
    int k = c.readInt();
    int[] aab = c.readIntArray(k);
    LinkedList<Pair<Integer, Integer>> q = new LinkedList<>();
    q.add(new Pair<>(aab[k - 1] - 1, 0));
    vis[aab[k - 1] - 1] = true;
    dd[aab[k - 1] - 1] = 0;
    hs[aab[k - 1] - 1] = 1;
    while (!q.isEmpty()) {
        Pair<Integer, Integer> pq = q.poll();
        for (int x : aa[pq.first]) {
            if (vis[x]) {
                if (dd[x] == pq.second + 1) {
                    hs[x]++;
                }
                continue;
            }
            q.add(new Pair<>(x, pq.second + 1));
            vis[x] = true;
            dd[x] = pq.second + 1;
            hs[x] = 1;
        }
    }
    int res = 0;
    int mm = 0;
    for (int i = 0; i < k - 1; i++) {
        if (dd[aab[i] - 1] != dd[aab[i + 1] - 1] + 1) {
            mm++;
        }
        if (dd[aab[i] - 1] == dd[aab[i + 1] - 1] + 1 && hs[aab[i] - 1] == 1) {
            continue;
        }
        res++;
    }
    w.printLine(mm, res);
}