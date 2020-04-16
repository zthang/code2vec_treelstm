public void union(int i, int j) {
    int root1 = findSet(i), root2 = findSet(j);
    if (root1 == root2)
        return;
    if (setSize[root1] > setSize[root2]) {
        p[root2] = root1;
        setSize[root1] += setSize[root2];
    } else {
        p[root1] = root2;
        setSize[root2] += setSize[root1];
    }
    setCount--;
}