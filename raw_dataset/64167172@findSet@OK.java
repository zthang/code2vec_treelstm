private static int findSet(int a) {
    return (parentSet[a] == a) ? a : findSet(parentSet[a]);
}