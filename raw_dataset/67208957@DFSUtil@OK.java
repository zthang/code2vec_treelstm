void DFSUtil(int v, boolean[] visited) {
    visited[v] = true;
    // System.out.print(v + " ");
    Iterator<Integer> i = adj[v].listIterator();
    while (i.hasNext()) {
        int n = i.next();
        if (!visited[n])
            DFSUtil(n, visited);
    }
}