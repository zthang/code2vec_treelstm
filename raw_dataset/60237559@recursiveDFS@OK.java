public static void recursiveDFS(Node root) {
    visited[root.n] = true;
    recStack[root.n] = true;
    for (Node child : root.children) {
        if (!visited[child.n]) {
            visited[child.n] = true;
            recursiveDFS(child);
        } else if (recStack[child.n]) {
            coloring[root.n][child.n] = true;
            colors = 2;
        }
    }
    recStack[root.n] = false;
}