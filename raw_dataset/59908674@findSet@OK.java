public int findSet(int i) {
    if (p[i] == i)
        return i;
    return p[i] = findSet(p[i]);
}