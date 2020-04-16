private void collect(int root, IntegerList circle) {
    while (root != -1) {
        circle.add(root);
        root = prev[root];
    }
}