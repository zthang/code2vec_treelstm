void solve() throws IOException {
    scanner = new FastScanner(System.in);
    writer = new PrintWriter(System.out);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    List<List<Integer>> invG = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
        invG.add(new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
        int u = scanner.nextInt() - 1;
        int v = scanner.nextInt() - 1;
        invG.get(v).add(u);
    }
    int k = scanner.nextInt();
    int[] ps = new int[k];
    for (int i = 0; i < k; i++) {
        ps[i] = scanner.nextInt() - 1;
    }
    int s = ps[0];
    int t = ps[k - 1];
    PathInfo[] paths = new PathInfo[n];
    for (int i = 0; i < n; i++) {
        paths[i] = new PathInfo(Integer.MAX_VALUE, 0);
    }
    paths[t].len = 0;
    paths[t].num = 1;
    Queue<Integer> q = new ArrayDeque<>();
    q.add(t);
    while (!q.isEmpty()) {
        int v = q.poll();
        PathInfo inf = paths[v];
        for (int u : invG.get(v)) {
            PathInfo uInf = paths[u];
            if (uInf.len == inf.len + 1) {
                uInf.num++;
            } else if (uInf.len > inf.len + 1) {
                uInf.len = inf.len + 1;
                uInf.num = 1;
                q.add(u);
            }
        }
    }
    int min = 0;
    int max = 0;
    PathInfo prevInf = paths[s];
    for (int i = 1; i < ps.length; i++) {
        PathInfo inf = paths[ps[i]];
        if (prevInf.len == inf.len + 1) {
            if (prevInf.num > 1) {
                max++;
            }
        } else {
            min++;
            max++;
        }
        prevInf = inf;
    }
    writer.println(min + " " + max);
    writer.close();
}