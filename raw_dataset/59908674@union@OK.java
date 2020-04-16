public void union(int i, int j) {
    int p1 = findSet(i);
    int p2 = findSet(j);
    if (p1 != p2) {
        if (rank[p1] > rank[p2]) {
            long pSize = setSize[p1];
            r -= (pSize * (pSize - 1)) / 2;
            pSize = setSize[p2];
            r -= (pSize * (pSize - 1)) / 2;
            p[p2] = p1;
            setSize[p1] += setSize[p2];
            pSize = setSize[p1];
            r += (pSize * (pSize - 1)) / 2;
        } else {
            long pSize = setSize[p1];
            r -= (pSize * (pSize - 1)) / 2;
            pSize = setSize[p2];
            r -= (pSize * (pSize - 1)) / 2;
            p[p1] = p2;
            setSize[p2] += setSize[p1];
            pSize = setSize[p2];
            r += (pSize * (pSize - 1)) / 2;
            if (rank[p1] == rank[p2]) {
                rank[p2]++;
            }
        }
    }
}