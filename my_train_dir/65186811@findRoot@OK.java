private int findRoot(int node) {
    while (disjointArray[node] != node) {
        disjointArray[node] = disjointArray[disjointArray[node]];
        node = disjointArray[node];
    }
    return node;
}