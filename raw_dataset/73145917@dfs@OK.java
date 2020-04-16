static void dfs(int x) {
    if (visited[x])
        return;
    visited[x] = true;
    for (Integer i : edge.get(x)) {
        if (!visited[i]) {
            children.get(x).add(i);
            parent[i] = x;
            dfs(i);
        }
    }
}