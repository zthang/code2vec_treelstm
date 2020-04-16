private void collect(int root) {
    while (root != -1) {
        circle.add(root);
        root = prev[root];
    }
}