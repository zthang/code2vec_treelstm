public void dfs(Nodes node) {
    node.color = 1;
    for (Edges edges : node.edges) {
        Nodes v = edges.v;
        if (v.color == 1) {
            ans = 2;
            edges.isBack = 2;
        } else if (v.color == 0) {
            dfs(v);
        }
    }
    node.color = 2;
}