public void dfs(Node root, int depth) {
    if (root.visited) {
        return;
    }
    root.visited = true;
    if (depth % 2 == 1) {
        dfs(root.opposite, depth + 1);
        return;
    }
    for (Node node : root.next) {
        dfs(node, depth + 1);
    }
}