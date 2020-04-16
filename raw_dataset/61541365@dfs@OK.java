private static void dfs(int v, Set<Integer> visited, Map<Integer, Set<Integer>> graph, int[] colors, Map<Integer, Long> colorsDistribution) {
    visited.add(v);
    int c = colors[v];
    if (colors.length - colorsDistribution.getOrDefault(c, 0L) != graph.getOrDefault(v, Collections.emptySet()).size()) {
        throw new RuntimeException();
    }
    for (int next : graph.getOrDefault(v, Collections.emptySet())) {
        if (colors[next] == c || colors[next] == 0) {
            throw new RuntimeException();
        }
        if (!visited.contains(next)) {
            dfs(next, visited, graph, colors, colorsDistribution);
        }
    }
}