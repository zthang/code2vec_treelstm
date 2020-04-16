static boolean isAncestor(int ancestor, int node) {
    return tin[ancestor] <= tin[node] && tout[ancestor] >= tout[node];
}