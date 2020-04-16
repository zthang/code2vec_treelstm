void solve() {
    n = in.nextInt();
    m = in.nextInt();
    nodes = new Node[n + 1];
    for (int i = 1; i <= n; i++) {
        nodes[i] = new Node();
    }
    for (int i = 0; i < m; i++) {
        int u = in.nextInt();
        int v = in.nextInt();
        nodes[u].out.add(v);
        nodes[v].in.add(u);
    }
    int k = in.nextInt();
    int[] path = in.nextArray(k);
    s = path[0];
    t = path[k - 1];
    reverseBfs();
    int min = 0;
    int max = 0;
    for (int i = 1; i < k; i++) {
        if (nodes[path[i - 1]].goods.contains(path[i])) {
            // min stays the same.
            if (nodes[path[i - 1]].goods.size() > 1) {
                max++;
            }
        } else {
            min++;
            max++;
        }
    }
    out.println(min + " " + max);
}