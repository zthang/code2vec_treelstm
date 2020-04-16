void union(int i, int j) {
    i = getParent(i);
    j = getParent(j);
    if (i != j) {
        p[j] = getParent(i);
    }
}