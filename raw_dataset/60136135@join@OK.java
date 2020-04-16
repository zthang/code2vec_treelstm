void join(int i, int j) {
    i = find(i);
    j = find(j);
    if (i == j)
        return;
    if (dsu[i] > dsu[j])
        dsu[i] = j;
    else {
        if (dsu[i] == dsu[j])
            dsu[i]--;
        dsu[j] = i;
    }
}