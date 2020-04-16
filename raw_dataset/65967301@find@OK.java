public int find(int i) {
    int p = _parent[i];
    if (i == p) {
        return i;
    }
    return _parent[i] = find(p);
}