private void pushUp(int node, int lo, int hi) {
    if (lo >= hi)
        return;
    // note that, if we need to call pushUp on a node, then lazy[node] must be zero.
    // the true value is the value + lazy
    treeMin[node] = Math.min(treeMin[node * 2] + lazy[node * 2], treeMin[node * 2 + 1] + lazy[node * 2 + 1]);
    treeMax[node] = Math.max(treeMax[node * 2] + lazy[node * 2], treeMax[node * 2 + 1] + lazy[node * 2 + 1]);
// add combine fcn
}