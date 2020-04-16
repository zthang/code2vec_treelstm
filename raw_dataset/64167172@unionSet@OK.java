private static void unionSet(int a, int b) {
    if (isSameSet(a, b))
        return;
    int pa = findSet(a);
    int pb = findSet(b);
    if (rankSet[pa] > rankSet[pb]) {
        parentSet[pb] = pa;
    } else {
        parentSet[pa] = pb;
        if (rankSet[pa] == rankSet[pb])
            rankSet[pb]++;
    }
}