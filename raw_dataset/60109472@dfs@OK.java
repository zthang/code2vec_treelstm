public void dfs(Node root, Edge from) {
    if (from != null && !root.instk) {
        from.c = color;
        cnt--;
    }
    if (root.visited) {
        return;
    }
    root.visited = true;
    root.instk = true;
    for (Edge e : root.edges) {
        if (e.c != 0) {
            continue;
        }
        dfs(e.next, e);
    }
    root.instk = false;
}