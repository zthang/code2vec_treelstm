public static void dfs(int node) {
    visited[node] = true;
    for (Integer child : adjList[node]) {
        if (!visited[child]) {
            maxMin = new Pair(Math.min(maxMin.a, child), Math.max(maxMin.b, child));
            dfs(child);
        }
    }
}