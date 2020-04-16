long dfs(int s, int p, int idx, int[] color, String pattern, List<List<Integer>> graph, int[][] colorCost) {
    int colorToPaint = pattern.charAt(idx) - '0';
    color[s] = colorToPaint + 1;
    long cost = colorCost[s][colorToPaint];
    for (Integer v : graph.get(s)) {
        if (v != p) {
            cost += dfs(v, s, (idx + 1) % 3, color, pattern, graph, colorCost);
        }
    }
    return cost;
}