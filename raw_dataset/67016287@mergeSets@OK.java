public void mergeSets(int x, int y) {
    int PX = findSet(x);
    int PY = findSet(y);
    if (PX == PY)
        return;
    disjointRoots--;
    if (rank[PX] > rank[PY]) {
        parent[PY] = PX;
        setSize[PX] = setSize[PX] + setSize[PY];
        max[PX] = Math.max(max[PX], max[PY]);
    } else {
        parent[PX] = PY;
        setSize[PY] = setSize[PX] + setSize[PY];
        max[PY] = Math.max(max[PX], max[PY]);
    }
    // 2 ta rank soman thaka means ekta tree er size barano
    if (rank[PX] == rank[PY])
        rank[PY] = rank[PY] + 1;
}