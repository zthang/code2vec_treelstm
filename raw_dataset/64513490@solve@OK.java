void solve() {
    int n = in.nextInt(), m = in.nextInt();
    int[] degree = new int[n];
    ArrayList<HashSet<Integer>> disConnected = new ArrayList<>();
    for (int i = 0; i < n; i++) disConnected.add(new HashSet<>());
    for (int i = 0; i < m; i++) {
        int a = in.nextInt() - 1;
        int b = in.nextInt() - 1;
        degree[a]++;
        degree[b]++;
        disConnected.get(a).add(b);
        disConnected.get(b).add(a);
    }
    int num = n, idx = -1;
    for (int i = 0; i < n; i++) {
        if (num > degree[i]) {
            num = degree[i];
            idx = i;
        }
    }
    UnionFind uf = new UnionFind(n);
    disConnected.get(idx).add(idx);
    for (int s : disConnected.get(idx)) {
        for (int t = 0; t < n; t++) {
            if (!disConnected.get(s).contains(t)) {
                // out.println(s + " " + t);
                uf.union(s, t);
            }
        }
    }
    out.println((uf.group - 1));
}