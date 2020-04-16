void union(int i, int j) {
    i = findSet(i);
    j = findSet(j);
    if (i == j)
        return;
    max[i] = Math.max(max[i], max[j]);
    par[j] = i;
}