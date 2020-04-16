int findRoot(int id) {
    if (root[id] != id) {
        root[id] = findRoot(root[id]);
    }
    return root[id];
}