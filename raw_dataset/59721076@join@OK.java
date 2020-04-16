long join(int i, int j) {
    i = find(i);
    j = find(j);
    if (i == j)
        return 0;
    long p = (long) dsu[i] * dsu[j];
    if (dsu[i] > dsu[j]) {
        int tmp = i;
        i = j;
        j = tmp;
    }
    dsu[i] += dsu[j];
    dsu[j] = i;
    return p;
}