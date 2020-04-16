public static void dfs1(ArrayList<ArrayList<Integer>> graph, final int src, boolean[] visited, Stack<Integer> stk) {
    visited[src] = true;
    for (int c : graph.get(src)) {
        if (visited[c])
            continue;
        dfs1(graph, c, visited, stk);
    }
    stk.push(src);
}