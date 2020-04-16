int find(int i) {
    return dsu[i] < 0 ? i : (dsu[i] = find(dsu[i]));
}