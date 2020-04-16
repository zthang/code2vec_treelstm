public static void connectedComponent() {
    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            DFSUtil(i, visited);
            count++;
        }
    }
}