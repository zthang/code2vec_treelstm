static void dfs(int node) {
    for (int adj : adjList[node]) {
        if (adj != firstParents[node]) {
            firstParents[adj] = node;
            depth[adj] = depth[node] + 1;
            maxDepth = Math.max(maxDepth, depth[adj]);
            dfs(adj);
        }
    }
}