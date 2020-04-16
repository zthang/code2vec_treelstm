boolean dfs(int node, int par) {
    graph[node].remove((Object) par);
    if (graph[node].size() > 1)
        return false;
    dfsOrder.add(node);
    if (graph[node].isEmpty())
        return true;
    return dfs(graph[node].get(0), node);
}