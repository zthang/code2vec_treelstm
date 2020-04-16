public void solve(int testNumber, FastInput in, FastOutput out) {
    int n = in.readInt();
    BNumbersOnTree.Node[] nodes = new BNumbersOnTree.Node[n + 1];
    for (int i = 1; i <= n; i++) {
        nodes[i] = new BNumbersOnTree.Node();
        nodes[i].id = i;
    }
    BNumbersOnTree.Node root = null;
    for (int i = 1; i <= n; i++) {
        BNumbersOnTree.Node p = nodes[in.readInt()];
        if (p == null) {
            root = nodes[i];
        } else {
            p.next.add(nodes[i]);
        }
        nodes[i].ci = in.readInt();
    }
    dfs(root);
    if (!valid) {
        out.println("NO");
        return;
    }
    out.println("YES");
    for (int i = 1; i <= n; i++) {
        Splay.splay(nodes[i].splay);
        out.append(nodes[i].splay.size - nodes[i].splay.right.size).append(' ');
    }
}