int findSet(int i) {
    return i == p[i] ? i : (p[i] = findSet(p[i]));
}