boolean linear(int n, List<List<Integer>> graph) {
    for (int i = 1; i <= n; i++) {
        if (graph.get(i).size() > 2) {
            return false;
        }
    }
    return true;
}