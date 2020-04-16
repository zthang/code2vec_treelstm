void union(int i, int j) {
    i = findSet(i);
    j = findSet(j);
    if (i == j)
        return;
    if (query[i].size() < query[j].size()) {
        int temp = i;
        i = j;
        j = temp;
    }
    par[j] = i;
    for (int k : query[j]) {
        if (query[i].contains(k)) {
            query[i].remove(k);
            ans[k] = cans;
        } else
            query[i].add(k);
    }
}