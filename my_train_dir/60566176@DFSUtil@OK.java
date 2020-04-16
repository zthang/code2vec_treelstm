boolean DFSUtil(int v, boolean[] visited) {
    // Mark the current node as visited and print it
    visited[v] = true;
    // Recur for all the vertices
    // adjacent to this vertex
    boolean nonempty = false;
    for (int x : adjListArray[v]) {
        if (!visited[x]) {
            nonempty = true;
            boolean l = DFSUtil(x, visited);
        }
    }
    return nonempty;
}