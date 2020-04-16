// we count the number of nodes and edges when seeking down this path
int[] precomp(int node) {
    // me
    int nodes = 1, edges = 0, res[];
    vis[node] = true;
    for (int[] edge : adj[node]) {
        int to = edge[1];
        if (vis[to]) {
            // if we've seen this, just count the edge
            edges++;
        } else {
            // if this edge goes to a tree, we want to note it
            res = precomp(to);
            edges += ++res[1];
            nodes += res[0];
            if (res[0] << 1 == res[1])
                trees.add(edge);
        }
    }
    return new int[] { nodes, edges };
}