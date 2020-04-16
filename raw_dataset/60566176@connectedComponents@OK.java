int connectedComponents() {
    int r = 0;
    // Mark all the vertices as not visited
    boolean[] visited = new boolean[V];
    for (int v = 0; v < V; ++v) {
        if (!visited[v]) {
            // print all reachable vertices
            // from v
            boolean err = DFSUtil(v, visited);
            if (err == true) {
                r++;
            }
        }
    }
    return r;
}