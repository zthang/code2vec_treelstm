int find(int x) {
    if (x == set[x]) {
        return x;
    }
    set[x] = find(set[x]);
    return set[x];
}