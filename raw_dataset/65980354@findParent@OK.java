int findParent(int idx) {
    if (root[idx] != idx)
        return findParent(root[idx]);
    return idx;
}