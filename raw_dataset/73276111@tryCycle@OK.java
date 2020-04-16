static boolean tryCycle(Node[] nodes) {
    for (Node nn : nodes) nn.hit = false;
    int n = nodes.length;
    int start = rand.nextInt(n);
    if (nodes[start].dfs(null, 0)) {
        return true;
    }
    return false;
}