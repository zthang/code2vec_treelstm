void dfs(Node root) {
    root.visited = true;
    for (Node node : root.next) {
        node = node.set;
        if (node.visited) {
            continue;
        }
        dfs(node);
        root.dp[0] = Math.max(node.dp[0] - node.dp[1], root.dp[0]);
        root.dp[1] += node.dp[1];
        root.meet = root.meet || node.meet;
    }
    root.dp[0] += root.dp[1] + root.w;
    root.meet = root.meet || root.size > 1;
    if (root.meet) {
        root.dp[1] += root.w;
    }
}