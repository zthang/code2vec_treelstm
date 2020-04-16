public void dfs(Node root, Node fa) {
    root.next.remove(fa);
    if (root.next.size() == 0) {
        root.best = root.dp[0] = root.dp[1] = 1;
        return;
    }
    ThreeElementHeap heap = new ThreeElementHeap();
    root.dp[1] = root.dp[0] = root.next.size() + 1;
    for (Node node : root.next) {
        dfs(node, root);
        heap.add(node.dp[0] - 1);
        root.best = Math.max(root.best, node.dp[0] + 1);
        root.best = Math.max(root.best, node.dp[1] + 1);
        root.best = Math.max(root.best, node.best);
    }
    root.dp[0] += heap.max();
    root.dp[1] += heap.max() + heap.second();
    root.best = Math.max(root.best, root.dp[0]);
    root.best = Math.max(root.best, root.dp[1]);
}