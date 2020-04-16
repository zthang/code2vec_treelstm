void propagate(int node, int b, int mid, int e) {
    lazy[node << 1] += lazy[node];
    lazy[node << 1 | 1] += lazy[node];
    sTree[node << 1] += (mid - b + 1) * lazy[node];
    sTree[node << 1 | 1] += (e - mid) * lazy[node];
    lazy[node] = 0;
}