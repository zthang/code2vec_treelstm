void mergeSet(int n, int m) {
    if (!isSameSet(n, m)) {
        numSets--;
        int p1 = findSet(n);
        int p2 = findSet(m);
        if (rank[p1] > rank[p2]) {
            p[p2] = p1;
            setSize[p1] += setSize[p2];
        } else {
            p[p1] = p2;
            setSize[p2] += setSize[p1];
            if (rank[p1] == rank[p2])
                rank[p1]++;
        }
    }
}