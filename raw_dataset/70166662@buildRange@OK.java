void buildRange(int node, int low, int high) {
    if (low == high) {
        tree[node] = arr[low];
        return;
    }
    int mid = (low + high) / 2;
    int left = node << 1;
    int right = left | 1;
    buildRange(left, low, mid);
    buildRange(right, mid + 1, high);
    tree[node] = max(tree[left], tree[right]);
}