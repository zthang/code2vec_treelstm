public void dfs(Node root, List<Node> trace) {
    if (root.p == null) {
        root.depth = 0;
    } else {
        root.depth = root.p.depth + 1;
    }
    root.dfn = trace.size();
    trace.add(root);
    for (Node node : root.next) {
        dfs(node, trace);
        trace.add(root);
    }
}