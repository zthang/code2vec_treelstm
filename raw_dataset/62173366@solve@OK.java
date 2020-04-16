public void solve() {
    int n = io.readInt();
    Node[] nodes = new Node[n + 1];
    for (int i = 1; i <= n; i++) {
        nodes[i] = new Node();
        nodes[i].id = i;
    }
    for (int i = 1; i < n; i++) {
        Node a = nodes[io.readInt()];
        Node b = nodes[io.readInt()];
        a.next.add(b);
        b.next.add(a);
    }
    dfs(nodes[1], null);
    io.cache.append(nodes[1].best).append('\n');
}