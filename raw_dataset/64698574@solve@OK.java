public void solve(int testNumber, FastInput in, FastOutput out) {
    int n = in.readInt();
    int m = in.readInt();
    Node[] nodes = new Node[n + 1];
    for (int i = 1; i <= n; i++) {
        nodes[i] = new Node();
        nodes[i].id = i;
        nodes[i].w = in.readInt();
    }
    for (int i = 0; i < m; i++) {
        Node a = nodes[in.readInt()];
        Node b = nodes[in.readInt()];
        a.next.add(b);
        b.next.add(a);
    }
    for (int i = 1; i <= n; i++) {
        tarjan(nodes[i], null);
    }
    Node root = nodes[in.readInt()].set;
    dfs(root);
    out.println(root.dp[0]);
}