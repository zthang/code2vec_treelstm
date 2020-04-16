int dfs(int v, List<List<Edge>> edges, boolean[] visited, Result r) {
    visited[v] = true;
    int subtreeSize = 1;
    for (Edge e : edges.get(v)) {
        if (!visited[e.to]) {
            int aSize = dfs(e.to, edges, visited, r);
            int bSize = edges.size() - aSize;
            r.b += ((long) Math.min(aSize, bSize)) * e.weight;
            if (aSize % 2 != 0)
                r.g += e.weight;
            subtreeSize += aSize;
        }
    }
    return subtreeSize;
}