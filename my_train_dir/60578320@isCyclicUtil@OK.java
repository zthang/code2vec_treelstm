static void isCyclicUtil(int v, Boolean[] visited, int parent) {
    // Mark the current node as visited
    visited[v] = true;
    Integer i;
    // Recur for all the vertices adjacent to this vertex
    for (int j = 0; j < adj.get(v).size(); j++) {
        i = adj.get(v).get(j);
        // adjacent
        if (!visited[i]) {
            isCyclicUtil(i, visited, v);
        } else // vertex, then there is a cycle.
        if (i != parent) {
            sum += 1;
            adj.get(v).remove(j);
            adj.get(i).remove(Collections.binarySearch(adj.get(i), v));
            j--;
        }
    }
    return;
}