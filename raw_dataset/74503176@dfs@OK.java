static void dfs(int index, int p) {
    in[index] = ++count;
    for (int next : adj[index]) {
        if (next != p) {
            parent[next] = index;
            dfs(next, index);
        }
    }
    outTime[index] = ++count;
}