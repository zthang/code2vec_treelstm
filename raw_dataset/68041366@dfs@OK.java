public static void dfs(int root, ArrayList<Node> graph, int[] color) {
    color[root] = 1;
    for (Integer nxt : graph.get(root).list) {
        if (color[nxt] == 0) {
            dfs(nxt, graph, color);
        }
    }
}