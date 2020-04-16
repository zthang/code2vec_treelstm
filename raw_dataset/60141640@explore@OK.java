public static void explore(ArrayList<Integer>[] adj, boolean[] visited, int v, int parent) {
    visited[v] = true;
    for (int i = 0; i < adj[v].size(); i++) {
        if (adj[v].get(i) == parent) {
            flag = false;
            return;
        }
        if (!visited[adj[v].get(i)])
            explore(adj, visited, adj[v].get(i), parent);
    }
}