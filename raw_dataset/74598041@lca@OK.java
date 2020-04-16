static int lca(int u, int v, Node root) {
    int left = Math.min(firstAppear[u], firstAppear[v]);
    int right = Math.max(firstAppear[u], firstAppear[v]);
    int index = queryMinIndex(left, right, root);
    return eulerTour[index];
}