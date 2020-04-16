private boolean _union(int n1, int n2) {
    if (n1 == n2)
        return true;
    if (setSize[n1] > setSize[n2]) {
        parent[n2] = parent[n1];
        setSize[n1] += setSize[n2];
    } else {
        parent[n1] = parent[n2];
        setSize[n2] += setSize[n1];
    }
    numOfSets--;
    return true;
}