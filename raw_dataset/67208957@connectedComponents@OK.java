int connectedComponents() {
    int a = 0;
    boolean[] visited = new boolean[V];
    for (int v = 0; v < V; ++v) {
        if (!visited[v]) {
            DFSUtil(v, visited);
            a++;
        // System.out.println();
        }
    }
    return a;
}