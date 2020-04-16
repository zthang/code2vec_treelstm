public void solve() {
    int n = io.readInt();
    int k = io.readInt();
    Node[] nodes = new Node[n + 1];
    for (int i = 1; i <= n; i++) {
        nodes[i] = new Node();
    }
    int cnt = 0;
    for (int i = 0; i < k; i++) {
        Node a = nodes[io.readInt()];
        Node b = nodes[io.readInt()];
        if (a.find() == b.find()) {
            continue;
        }
        cnt++;
        Node.merge(a, b);
    }
    io.cache.append(k - cnt);
}