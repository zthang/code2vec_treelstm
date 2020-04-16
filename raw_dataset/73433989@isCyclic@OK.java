// Returns true if the graph contains a
// cycle, else false.
// This function is a variation of DFS() in
// https://www.geeksforgeeks.org/archives/18212
private boolean isCyclic() {
    // Mark all the vertices as not visited and
    // not part of recursion stack
    boolean[] visited = new boolean[V];
    boolean[] recStack = new boolean[V];
    // detect cycle in different DFS trees
    for (int i = 0; i < V; i++) if (isCyclicUtil(i, visited, recStack))
        return true;
    return false;
}