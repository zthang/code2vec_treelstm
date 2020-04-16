public static void dfs(int node) {
    used[node] = true;
    ArrayList<Integer> nn = graph.get(node);
    if (nn.size() >= 3) {
        can = false;
    }
    if (nn.size() == 1) {
        start = node;
    }
    for (Integer n : nn) {
        if (!used[n]) {
            dfs(n);
        }
    }
}