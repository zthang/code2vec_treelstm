public static void DFSUtil(int s, boolean[] visited) {
    visited[s] = true;
    for (int i = 0; i < adj[s].size(); i++) {
        int y = adj[s].get(i);
        if (!visited[y]) {
            DFSUtil(y, visited);
        }
    }
}