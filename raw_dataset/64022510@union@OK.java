public void union(int[] parent, int x, int y) {
    int x_set_parent = find(parent, x);
    int y_set_parent = find(parent, y);
    // make x as parent of y
    parent[y_set_parent] = x_set_parent;
}