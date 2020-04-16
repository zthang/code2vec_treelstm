// O(n)
void build(// O(n)
int node, // O(n)
int b, // O(n)
int e) {
    if (b == e)
        sTree[node] = array[b];
    else {
        int mid = b + e >> 1;
        build(node << 1, b, mid);
        build(node << 1 | 1, mid + 1, e);
        sTree[node] = sTree[node << 1] + sTree[node << 1 | 1];
    }
}