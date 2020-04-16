private void pushUp(int node, int lo, int hi) {
    if (lo >= hi)
        return;
    int lid = tree[node * 2];
    int rid = tree[node * 2 + 1];
    int tid = a[lid] >= a[rid] ? lid : rid;
    tree[node] = tid;
// add combine fcn
}