int find(int p) {
    if (p != root[p]) {
        root[p] = find(root[p]);
    }
    return root[p];
}