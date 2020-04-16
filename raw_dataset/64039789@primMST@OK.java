void primMST(long[][] graph) {
    // Array to store constructed MST
    // Key values used to pick minimum weight edge in cut
    long[] key = new long[V];
    // To represent set of vertices not yet included in MST
    Boolean[] mstSet = new Boolean[V];
    // Initialize all keys as INFINITE
    for (int i = 0; i < V; i++) {
        key[i] = Long.MAX_VALUE;
        mstSet[i] = false;
    }
    // Always include first 1st vertex in MST.
    // Make key 0 so that this vertex is
    key[0] = 0;
    // picked as first vertex
    // First node is always root of MST
    parent[0] = -1;
    // The MST will have V vertices
    for (int count = 0; count < V - 1; count++) {
        // Pick thd minimum key vertex from the set of vertices
        // not yet included in MST
        int u = minKey(key, mstSet);
        // Add the picked vertex to the MST Set
        mstSet[u] = true;
        // vertices which are not yet included in MST
        for (int v = 0; v < V; v++) // Update the key only if graph[u][v] is smaller than key[v]
        if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
            parent[v] = u;
            key[v] = graph[u][v];
        }
    }
}