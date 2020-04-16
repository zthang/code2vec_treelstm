void evalGrid(int n, int p) {
    if (minDevice[n] != -1) {
        // This is a leaf node
        return;
    }
    int mind = INF, maxd = -INF, edges = 0;
    for (int e : adj[n]) {
        if (e != p) {
            evalGrid(e, n);
            mind = Math.min(minDevice[e], mind);
            maxd = Math.max(maxDevice[e], maxd);
            edges += numEdges[e] + 1;
            // Set bonus for child node
            bonus[minDevice[e]][maxDevice[e]] = Math.max(numEdges[e] + 1, bonus[minDevice[e]][maxDevice[e]]);
        }
    }
    minDevice[n] = mind;
    maxDevice[n] = maxd;
    numEdges[n] = edges;
}